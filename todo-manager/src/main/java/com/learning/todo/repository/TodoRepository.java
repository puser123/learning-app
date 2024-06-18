package com.learning.todo.repository;

import com.learning.todo.model.entity.TODOEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TodoRepository extends ReactiveCrudRepository<TODOEntity, UUID> {
}
