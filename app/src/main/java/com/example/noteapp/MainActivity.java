package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private int noteId;
    public static final String NOTE_ID = "note_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        final EditText editTitle = findViewById(R.id.editTitle);
        final EditText editDescription = findViewById(R.id.editDescription);
        Button buttonSave = findViewById(R.id.btnSave);
        Button buttonDelete = findViewById(R.id.btnDelete);

        buttonSave.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String noteTitle = editTitle.getText().toString();
                    String noteDescription = editDescription.getText().toString();
                    Note note;
                    if (noteId == -1) {
                        int id = (int) (Math.random() * 100000);
                        note = new Note(id, noteTitle, noteDescription);
                    } else {
                        note = DatabaseHelper.getDb(getApplicationContext()).noteDao().getNoteById(noteId);
                        note.setTitle(noteTitle);
                        note.setDescription(noteDescription);
                    }
                    DatabaseHelper.getDb(getApplicationContext()).noteDao().insertNote(note);
                    finish();
                }
            }
        );

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noteId != -1) {
                    DatabaseHelper.getDb(getApplicationContext()).noteDao().deleteNote(noteId);
                    finish();
                }
            }
        });

        noteId = getIntent().getIntExtra(NOTE_ID, -1);

        if (noteId != -1) {
            // aldingisin ozgertip atirmiz
            Note note = DatabaseHelper.getDb(getApplicationContext()).noteDao().getNoteById(noteId);

            if (note != null) {
                buttonDelete.setVisibility(View.VISIBLE);

                editTitle.setText(note.getTitle());
                editDescription.setText(note.getDescription());
                buttonSave.setText("Update");
            }
        }
    }
}
