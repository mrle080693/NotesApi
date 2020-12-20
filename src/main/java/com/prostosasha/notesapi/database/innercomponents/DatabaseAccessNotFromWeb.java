package com.prostosasha.notesapi.database.innercomponents;

import com.prostosasha.notesapi.database.NoteRepository;
import com.prostosasha.notesapi.database.UserRepository;
import com.prostosasha.notesapi.entities.Note;
import com.prostosasha.notesapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseAccessNotFromWeb {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public void save(Note note) {
        noteRepository.save(note);
    }

    public void saveAll(List<Note> notes) {
        noteRepository.saveAll(notes);
    }
}
