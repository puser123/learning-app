package com.learning.note.controller;

import com.learning.note.model.entity.NoteEntity;
import com.learning.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
public class NoteAppController {


    @Autowired
    private NoteService noteService;

    public Mono<ServerResponse> createNote(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(NoteEntity.class)
                .flatMap(note -> noteService.createNote(note))
                .flatMap(note -> ServerResponse.ok()
                        .body(Mono.just(note), NoteEntity.class));
    }
    public Mono<ServerResponse> getNote(ServerRequest serverRequest) {
        String noteId = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                        .body(Mono.just("note"), String.class);
    }
}
