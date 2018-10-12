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
                    String titleAndDescription = editTitle.getText().toString() + " - " + editDescription.getText().toString();
                    Toast.makeText(MainActivity.this, titleAndDescription, Toast.LENGTH_LONG).show();
                }
            }
        );
    }
}
