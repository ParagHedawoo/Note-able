package com.example.paraghedawoo.note_able;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Parag Hedawoo on 3/16/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Note> noteList;
    Context context;

    public RecyclerAdapter(Context context, List<Note> noteList){
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_layout, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.noteTitle.setText(noteList.get(position).getTitle());
        holder.noteContent.setText(noteList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return this.noteList.size();
    }
}
