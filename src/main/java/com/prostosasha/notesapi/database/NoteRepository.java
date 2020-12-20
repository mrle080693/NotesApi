package com.prostosasha.notesapi.database;

import com.prostosasha.notesapi.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUserId(int userId);
    @Transactional
    void deleteAllByUserId(int userId);
}
