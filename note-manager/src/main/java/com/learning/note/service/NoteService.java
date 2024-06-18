package com.learning.note.service;

import com.learning.note.model.entity.NoteEntity;
import reactor.core.publisher.Mono;

public interface NoteService {
    Mono<NoteEntity> createNote(NoteEntity note);
}
