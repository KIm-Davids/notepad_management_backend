package com.semicolon.africa.models;

import com.semicolon.africa.dtos.request.AddNoteServicesRequest;
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

    @Test
    public void testThatWeCanAddNotes() {
        AddNoteResponse request = createNewNote();
        assertThat(request).isNotNull();
        assertThat(repository.findAll().size()).isEqualTo(1L);

    }

    private AddNoteResponse createNewNote() {
        AddNoteServicesRequest request = new AddNoteServicesRequest();
        request.setTitle("title");
        request.setContent("content");
        return noteServices.AddNoteServices(request);
    }

    @Test
    public void testThatWeCanDeleteNote() {
        AddNoteResponse newNote = createNewNote();
        DeleteNoteResponse response = noteServices.DeleteNoteServices(newNote.getTitle());
        String title = newNote.getTitle();
        assertThat(response.getMessage()).contains("Deleted Successfully");
    }

    @Test
    public void testThatWeCanUpdateNote() {
        AddNoteResponse newNote = createNewNote();
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

}
