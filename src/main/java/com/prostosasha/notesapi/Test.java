package com.prostosasha.notesapi;

import com.prostosasha.notesapi.configs.DataSourceConfig;
import com.prostosasha.notesapi.database.innercomponents.DatabaseAccessNotFromWeb;
import com.prostosasha.notesapi.entities.Note;
import com.prostosasha.notesapi.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfig.class);

    public static void main(String[] args) {
        DatabaseAccessNotFromWeb databaseAccessNotFromWeb = applicationContext.getBean(DatabaseAccessNotFromWeb.class);

        List<Note> notesForSaveAll = new ArrayList<>();
        notesForSaveAll.add(new Note(0, "Try saveAll 1"));
        notesForSaveAll.add(new Note(0, "Try saveAll 2"));
        notesForSaveAll.add(new Note(0, "Try saveAll 3"));

        databaseAccessNotFromWeb.saveAll(notesForSaveAll);

        List<Note> notes = databaseAccessNotFromWeb.findAllNotes();
        for (Note note : notes) {
            System.out.println(note.toString());
        }
    }
}
