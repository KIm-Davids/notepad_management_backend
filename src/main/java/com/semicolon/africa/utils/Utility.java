package com.semicolon.africa.utils;

import com.semicolon.africa.dtos.request.AddNoteServicesRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.FindNoteByIdResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponse;
import com.semicolon.africa.models.Note;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Utility {

    public static Note setRequestToNote(AddNoteServicesRequest request){
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setDateCreated(LocalDateTime.now());
        return note;
    }

//    public static AddNoteResponse alreadySetNoteResponse(Note note){
//        AddNoteResponse response = new AddNoteResponse();
//        response.setId(note.getId());
//        response.setTitle(note.getTitle());
//        response.setContent(note.getContent());
//        response.setDateCreated(LocalDateTime.now());
//        return response;
//    }

    public static UpdateNoteResponse UpdateNoteResponseUtility(UpdateNoteRequest request){
        Note note = new Note();
        UpdateNoteResponse response = new UpdateNoteResponse();
        response.setMessage("Updated Note Successfully");
        note.setId(request.getId());
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setDateCreated(LocalDateTime.now());
        return response;
    }

}
