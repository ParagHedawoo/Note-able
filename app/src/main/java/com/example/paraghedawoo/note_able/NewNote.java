package com.example.paraghedawoo.note_able;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import static com.example.paraghedawoo.note_able.MainActivity.adapter;
import static com.example.paraghedawoo.note_able.MainActivity.dbAdapter;
import static com.example.paraghedawoo.note_able.MainActivity.noteList;

public class NewNote extends AppCompatActivity {

    EditText titleView, contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        titleView = (EditText)findViewById(R.id.titleView);
        contentView = (EditText)findViewById(R.id.contentView);
    }

    @Override
    public void onBackPressed() {
        if (!(titleView.getText().toString().trim().equals("") && contentView.getText().toString().trim().equals("")))
        {
            noteList.add(dbAdapter.addNewNote(titleView.getText().toString(), contentView.getText().toString()));
            adapter.notifyDataSetChanged();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            if (!(titleView.getText().toString().equals("") && contentView.getText().toString().equals("")))
            {
                noteList.add(dbAdapter.addNewNote(titleView.getText().toString(), contentView.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
