package com.learning.todo.util;

import com.learning.todo.context.TodoContext;
import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import com.netflix.graphql.dgs.reactive.DgsReactiveCustomContextBuilderWithRequest;
import jakarta.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.net.http.HttpHeaders;
import java.util.Map;
import java.util.UUID;

@Component
public class TodoContextBuilder implements DgsReactiveCustomContextBuilderWithRequest<TodoContext> {

    @NotNull
    @Override
    public Mono<TodoContext> build(@Nullable  Map<String, ?> map, @Nullable org.springframework.http.HttpHeaders httpHeaders, @Nullable ServerRequest serverRequest) {
        TodoContext todoContext = new TodoContext();
        todoContext.setHttpHeaders(httpHeaders);
        return Mono.deferContextual(contextView -> {
           todoContext.setRequestId(contextView.getOrDefault("requestId", UUID.randomUUID().toString()));
           return Mono.just(todoContext);
        });
    }
}
