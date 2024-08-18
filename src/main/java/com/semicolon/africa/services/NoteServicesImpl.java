package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.AddNoteServicesRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.request.FindNoteByIdRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.FindNoteByIdResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponse;
import com.semicolon.africa.exception.TitleExistException;
import com.semicolon.africa.models.Note;
import com.semicolon.africa.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.semicolon.africa.utils.Utility.*;

@Service
public class NoteServicesImpl implements NoteServices {

    private final NoteRepository repository;

    private NoteServicesImpl(NoteRepository repository){
        this.repository = repository;
    }

    public AddNoteResponse AddNoteServices(AddNoteServicesRequest request) {
        validateTitle(request);
        AddNoteResponse response = new AddNoteResponse();
        Note note = setRequestToNote(request);
        repository.save(note);
        response.setMessage("Added Note Successfully");
        return response;
    }

    @Override
    public DeleteNoteResponse DeleteNoteServices(DeleteNoteRequest request) {
        Note noteToBeDeleted = repository.findNoteByTitle(request.getTitle());
        repository.delete(noteToBeDeleted);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Deleted Successfully");
        return response;
    }

//    @Override
//    public FindNoteByIdResponse findNoteById(FindNoteByIdRequest request) {
//        Note note = new Note();
//        FindNoteByIdResponse response = new FindNoteByIdResponse();
//        repository.findNoteById(request.getId());
//        note.setId(request.getId());
//        note.setTitle(request.getTitle());
//        note.setContent(request.getContent());
//        repository.save(note);
//        return response;
//    }

    @Override
    public UpdateNoteResponse UpdateNoteServices(UpdateNoteRequest request) {
        UpdateNoteResponse response = new UpdateNoteResponse();
        Note noteFound = findNoteByTitle(request.getTitle());
        noteFound.setTitle(request.getTitle());
        noteFound.setContent(request.getContent());
        noteFound.setDateCreated(LocalDateTime.now());
        response.setMessage("Updated Successfully");
        return response;
    }

    private Note findNoteByTitle(String title){
        return repository.findNoteByTitle(title);
    }

    private void validateTitle(AddNoteServicesRequest request){
        if(request.getTitle().equals(repository.findNoteByTitle(request.getTitle()))) throw new TitleExistException("Title already exists");
    }
}
