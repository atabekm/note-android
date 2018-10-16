package com.example.noteapp;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static NoteRepository instance;
    private List<Note> notes = new ArrayList<>();

    public static NoteRepository getInstance() {
        if (instance == null) {
            instance = new NoteRepository();
        }
        return instance;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void updateNote(Note note) {
        for (int i = 0; i < notes.size(); i++) {
            Note n = notes.get(i);
            if (note.getId() == n.getId()) {
                notes.set(i, n);
            }
        }
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note getNoteById(int id) {
        for (Note n : notes) {
            if (id == n.getId()) {
                return n;
            }
        }

        return null;
    }

    public void deleteNoteById(int id) {
        for (Note n : notes) {
            if (id == n.getId()) {
                notes.remove(n);
            }
        }
    }
}
