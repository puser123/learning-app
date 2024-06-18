package com.learning.note.repository;

import com.learning.note.model.entity.NoteEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends ReactiveCrudRepository<NoteEntity, UUID> {

}
