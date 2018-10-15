package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        final EditText editTitle = findViewById(R.id.editTitle);
        final EditText editDescription = findViewById(R.id.editDescription);
        Button buttonSave = findViewById(R.id.btnSave);

        buttonSave.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note newNote = new Note(editTitle.getText().toString(), editDescription.getText().toString());
                    NoteRepository.getInstance().addNote(newNote);
                    Toast.makeText(MainActivity.this, NoteRepository.getInstance().getNotes().get(0).toString(), Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        );
    }
}
