package com.semicolon.africa.repository;

import com.semicolon.africa.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
    Note findNoteByTitle(String title);
    Note findNoteById(String id);
}
