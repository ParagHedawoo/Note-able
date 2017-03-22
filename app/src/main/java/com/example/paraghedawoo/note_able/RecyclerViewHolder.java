package com.example.paraghedawoo.note_able;

import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Parag Hedawoo on 3/16/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView noteTitle;
    public TextView noteContent;
    public CardView cardView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        noteTitle = (TextView) itemView.findViewById(R.id.noteTitleView);
        noteContent = (TextView) itemView.findViewById(R.id.noteContentView);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Item tapped", Snackbar.LENGTH_SHORT)
                .setAction("Ok ?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Done", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
