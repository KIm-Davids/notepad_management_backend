package com.semicolon.africa.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindNoteByIdRequest {

    private String id;
    private String title;
    private String content;
}
