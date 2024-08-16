package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddNoteServicesRequest {

    private String id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
}
