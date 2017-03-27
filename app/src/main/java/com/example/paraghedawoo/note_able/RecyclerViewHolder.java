package com.example.paraghedawoo.note_able;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.paraghedawoo.note_able.DBAdapter.getNote;
import static com.example.paraghedawoo.note_able.MainActivity.adapter;
import static com.example.paraghedawoo.note_able.MainActivity.dbAdapter;
import static com.example.paraghedawoo.note_able.MainActivity.noteList;

/**
 * Created by Parag Hedawoo on 3/16/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView noteTitle;
    public TextView noteContent;
    public CardView cardView;

    public RecyclerViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        noteTitle = (TextView) itemView.findViewById(R.id.noteTitleView);
        noteContent = (TextView) itemView.findViewById(R.id.noteContentView);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Delete?")
                        .setMessage("Are you sure you want to delete this note?")
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbAdapter.deleteNote(getAdapterPosition());
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setPositiveButton("Cancel", null)
                        .show();
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, String.valueOf(getAdapterPosition()), Snackbar.LENGTH_SHORT)
                .setAction("Ok ?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "done", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    @Override
    public boolean onLongClick(View v) {

        return true;
    }
}
