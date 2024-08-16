package com.semicolon.africa.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Note {

    private String id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    @DBRef
    List<Note> notes;

}
