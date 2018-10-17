package com.example.noteapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    List<Note> getNotes();

    @Query("SELECT * FROM note WHERE id = :noteId")
    Note getNoteById(int noteId);

    @Query("DELETE FROM note WHERE id = :noteId")
    void deleteNote(int noteId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note notes);

}
