package com.semicolon.africa.web.controller;

import com.semicolon.africa.dtos.request.AddNoteServicesRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.NoteServices;
import com.semicolon.africa.services.NoteServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/notepad")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class noteController {

    private NoteServicesImpl services;

    @PostMapping("/create-note")
    public ResponseEntity<?> createNote(@RequestBody AddNoteServicesRequest request) {
        try {
            AddNoteResponse response = services.AddNoteServices(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_GATEWAY);
        }
    }

    @PutMapping("/update-note")
    public ResponseEntity<?> editNote(@RequestBody UpdateNoteRequest request){
        try{
            UpdateNoteResponse response = services.UpdateNoteServices(request);
            return new ResponseEntity<>(new ApiResponse(true, response),OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-note")
    public ResponseEntity<?> deleteNote(@RequestBody DeleteNoteRequest request ) {
        try {
            DeleteNoteResponse response = services.DeleteNoteServices(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
}
