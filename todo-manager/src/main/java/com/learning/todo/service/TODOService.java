package com.learning.todo.service;

import com.learning.todo.model.entity.TODOEntity;
import com.learning.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TODOService {

    @Autowired private TodoRepository todoRepository;

    public Mono<TODOEntity> saveTodo(TODOEntity todoEntity) {
        return todoRepository.save(todoEntity)
                .flatMap(note -> todoRepository.findById(note.getId()));
    }


}
