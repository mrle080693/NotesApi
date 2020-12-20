package com.prostosasha.notesapi.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "notes")
@Proxy(lazy = false)
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "note_message")
    private String noteMessage;

    public Note() {
    }


    public Note(int userId, String noteMessage) {
        this.userId = userId;
        this.noteMessage = noteMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNoteMessage() {
        return noteMessage;
    }

    public void setNoteMessage(String noteMessage) {
        this.noteMessage = noteMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id &&
                userId == note.userId &&
                Objects.equals(noteMessage, note.noteMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, noteMessage);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", userId=" + userId +
                ", noteMessage='" + noteMessage + '\'' +
                '}';
    }
}
