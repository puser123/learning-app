package com.learning.todo.context;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

@Data
public class TodoContext {
    private HttpHeaders httpHeaders;
    private String dataFetchingName;
    private String requestId;
}
