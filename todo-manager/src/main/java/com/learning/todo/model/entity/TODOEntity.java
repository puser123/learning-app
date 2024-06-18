package com.learning.todo.model.entity;

import com.learning.todo.model.enums.CommonStatus;
import lombok.Data;
import org.springframework.aot.generate.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("todo")
@Data
@Generated()
public class TODOEntity {

    @Id
    private UUID id;
    @Column("userid")
    private UUID userId;
    private String title;
    private String description;
    private CommonStatus status;
    @Column("createddate")
    private LocalDate createdDate;
    @Column("updateddate")
    private LocalDate updatedDate;
    @Column("scheduledstartdate")
    private LocalDate scheduledStartDate;
    @Column("scheduledenddate")
    private LocalDate scheduledEndDate;
}
