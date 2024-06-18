package com.learning.note.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("note")
public class NoteEntity {

    @Id
    private UUID id;
    @Column("title")
    private String title;
    @Column("description")
    private String description;
}
