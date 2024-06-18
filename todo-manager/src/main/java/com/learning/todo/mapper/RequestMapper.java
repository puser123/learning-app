package com.learning.todo.mapper;

import com.learning.todo.dto.graphql.CreateTodoInput;
import com.learning.todo.model.entity.TODOEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestMapper {

    public TODOEntity mapToTodoEntity(CreateTodoInput createTodoInput) {
        TODOEntity todoEntity = new TODOEntity();
        todoEntity.setTitle(createTodoInput.getTitle());
        todoEntity.setUserId(UUID.randomUUID());
        todoEntity.setDescription(createTodoInput.getDescription());
        todoEntity.setScheduledStartDate(createTodoInput.getScheduledStartDate());
        todoEntity.setScheduledEndDate(createTodoInput.getScheduledEndDate());
        return todoEntity;
    }
}
