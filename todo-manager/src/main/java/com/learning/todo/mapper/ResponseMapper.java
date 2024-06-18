package com.learning.todo.mapper;

import com.learning.todo.dto.graphql.Status;
import com.learning.todo.dto.graphql.TODOCard;
import com.learning.todo.model.entity.TODOEntity;
import com.learning.todo.model.enums.CommonStatus;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@Slf4j
public abstract class ResponseMapper {

    @Mapping(target = "status", expression = "java(mapStatus(todoEntity.getStatus()))")
    public abstract TODOCard mapTodoCard(TODOEntity todoEntity);

    Status mapStatus(CommonStatus status) {
        return Status.valueOf(status.name());
    }
}
