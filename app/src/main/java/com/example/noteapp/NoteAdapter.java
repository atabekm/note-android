package com.example.noteapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] notes;

    public NoteAdapter(String[] notesList) {
        notes = notesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView text = (TextView) LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_note, viewGroup, false);
        return new NoteViewHolder(text);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((NoteViewHolder) viewHolder).textView.setText(notes[i]);
    }

    @Override
    public int getItemCount() {
        return notes.length;
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
