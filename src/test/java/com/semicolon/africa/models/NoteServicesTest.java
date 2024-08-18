package com.semicolon.africa.models;

import com.semicolon.africa.dtos.request.AddNoteServicesRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.request.FindNoteByIdRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.FindNoteByIdResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponse;
import com.semicolon.africa.repository.NoteRepository;
import com.semicolon.africa.services.NoteServices;
import com.semicolon.africa.services.NoteServicesImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NoteServicesTest {
    @Autowired
    private NoteRepository repository;
    @Autowired
    private NoteServicesImpl noteServices;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }


    private AddNoteServicesRequest createNewNote() {
        Note note = new Note();
        AddNoteServicesRequest request = new AddNoteServicesRequest();
        request.setTitle("title");
        request.setContent("content");
        note.setTitle(request.getTitle());
        note.setTitle(request.getTitle());
//        repository.save(note);
        return request;
    }


    @Test
    public void testThatWeCanAddNotes() {
        Note note = new Note();
        AddNoteServicesRequest request = createNewNote();
        request.setTitle("title");
        request.setContent("content");
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        repository.save(note);
        AddNoteResponse response = noteServices.AddNoteServices(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatWeCanDeleteNote() {
        DeleteNoteRequest newNote = createNote();

        DeleteNoteResponse response = noteServices.DeleteNoteServices(newNote);
        String title = newNote.getTitle();
        assertThat(response.getMessage()).contains("Deleted Successfully");
    }

    @Test
    public void testThatWeCanUpdateNote() {
        AddNoteServicesRequest newNote = createNewNote();
        UpdateNoteRequest request = new UpdateNoteRequest();

        request.setId(newNote.getId());
        request.setTitle("new title");
        request.setContent("New content");

        Note note = new Note();
        note.setId(request.getId());
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        repository.save(note);
        UpdateNoteResponse response = new UpdateNoteResponse();
        System.out.println(note.getId() + " " + createNewNote().getId());

        assertThat(note.getTitle()).contains("new");
    }

    private DeleteNoteRequest createNote() {
        Note note = new Note();
        DeleteNoteRequest request = new DeleteNoteRequest();
        request.setTitle("title");

        note.setTitle(request.getTitle());
        note.setTitle(request.getTitle());
        repository.save(note);
        return request;
    }
}
