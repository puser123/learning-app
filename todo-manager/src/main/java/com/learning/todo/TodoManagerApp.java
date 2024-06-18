package com.learning.todo;


import com.learning.todo.mapper.ResponseMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class TodoManagerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TodoManagerApp.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

    @Bean
    public ResponseMapper responseMapperObject() {
        return Mappers.getMapper(ResponseMapper.class);
    }
}
