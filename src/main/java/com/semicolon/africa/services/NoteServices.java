package com.semicolon.africa.services;


import com.semicolon.africa.dtos.request.AddNoteServicesRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.request.FindNoteByIdRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.FindNoteByIdResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponse;

public interface NoteServices {

    AddNoteResponse AddNoteServices(AddNoteServicesRequest request);
    DeleteNoteResponse DeleteNoteServices(DeleteNoteRequest request);
    UpdateNoteResponse UpdateNoteServices(UpdateNoteRequest request);
}
