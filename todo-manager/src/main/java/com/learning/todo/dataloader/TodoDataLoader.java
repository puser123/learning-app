package com.learning.todo.dataloader;

import com.learning.todo.context.TodoContext;
import com.learning.todo.dto.graphql.CreateTodoInput;
import com.learning.todo.dto.graphql.TODOCard;
import com.learning.todo.mapper.RequestMapper;
import com.learning.todo.mapper.ResponseMapper;
import com.learning.todo.service.TODOService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@DgsComponent
public class TodoDataLoader {

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private TODOService todoService;

    @DgsData(parentType = "Mutation", field = "createTodo")
    public Mono<TODOCard> createTodo(@InputArgument CreateTodoInput createTodoInput, DataFetchingEnvironment dfe) {
        return todoService.saveTodo(requestMapper.mapToTodoEntity(createTodoInput))
                .map(responseMapper::mapTodoCard);
    }

    public TodoContext getCustomContext(DataFetchingEnvironment dfe) {
        return (TodoContext) DgsContext.getCustomContext(dfe);
    }
}
