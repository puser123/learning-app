package com.learning.note;


import com.learning.note.controller.NoteAppController;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.*;

@SpringBootApplication
@EnableWebFlux
public class NoteManagerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(NoteManagerApp.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

    @Bean
    public RouterFunction<ServerResponse> noteManagerAPI(NoteAppController noteAppController) {

        return RouterFunctions.route(RequestPredicates.POST("/note"), noteAppController::createNote)
                .andRoute(RequestPredicates.GET("/note/{id}"), noteAppController::getNote);
    }
}
