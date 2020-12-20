package com.prostosasha.notesapi.services;

import com.prostosasha.notesapi.database.NoteRepository;
import com.prostosasha.notesapi.database.UserRepository;
import com.prostosasha.notesapi.entities.Note;
import com.prostosasha.notesapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> load(String username, String password) {
        List<Note> notes = new ArrayList<>();
        User user = userRepository.findUserByUsernameAndPassword(username, password);

        if (user == null) {
            user = userRepository.save(new User(username, password));
        }

        notes = noteRepository.findAllByUserId(user.getId());

        if (notes.isEmpty()) {
            notes.add(new Note(user.getId(), "Your First Note :)"));
        }

        return notes;
    }

    public Boolean save(List<Note> notes) {
        System.out.println("Save Input SERVICE");
        for (Note note : notes) {
            System.out.println(note.toString());
        }

        boolean wasSaved = false;

        noteRepository.deleteAllByUserId(notes.get(0).getUserId());
        List<Note> returnedNotes = noteRepository.saveAll(notes);

        System.out.println("Save Output SERVICE");
        for (Note note : returnedNotes) {
            System.out.println(note.toString());
        }

        if (returnedNotes != null && !returnedNotes.isEmpty()) {
            wasSaved = true;
        }

        return wasSaved;
    }
}
