package com.learning.note.service.impl;

import com.learning.note.model.entity.NoteEntity;
import com.learning.note.repository.NoteRepository;
import com.learning.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Mono<NoteEntity> createNote(NoteEntity note) {
        return noteRepository.save(note);
    }
}
