package com.example.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity activity;
    private List<Note> notes;

    public NoteAdapter(Activity activity, List<Note> notesList) {
        this.activity = activity;
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
        Note note = notes.get(i);
        NoteViewHolder holder = (NoteViewHolder) viewHolder;
        holder.textView.setText(note.getTitle() + " : " + note.getDescription());
        holder.setListener(activity, note.getId());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }

        void setListener(final Activity activity, final int id) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    intent.putExtra(MainActivity.NOTE_ID, id);
                    activity.startActivity(intent);
                }
            });
        }
    }
}
