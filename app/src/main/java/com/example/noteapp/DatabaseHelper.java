package com.example.noteapp;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseHelper {

    public static NoteDatabase getDb(Context context) {
        return Room.databaseBuilder(context, NoteDatabase.class, "note-db")
            .allowMainThreadQueries()
            .build();
    }

}
