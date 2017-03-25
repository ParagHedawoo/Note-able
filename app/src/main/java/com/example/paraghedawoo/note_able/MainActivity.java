package com.example.paraghedawoo.note_able;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static EditText setNoteTitle;
    static EditText setNoteContent;
    RecyclerView recyclerView;
    DBAdapter dbAdapter;
    ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new DBAdapter(this);
        dbAdapter.openDB();

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), NewNote.class));
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        List<Note> noteList = dbAdapter.getAllNotes();
        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, noteList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Note> getListItemData(){
        List<Note> list = new ArrayList<>();
        list.add(new Note("Title 1", "this is content for 1", 1));
        list.add(new Note("Title 2", "this is content for 2", 2));
        list.add(new Note("Title 3", "this is content for 3", 3));
        list.add(new Note("Title 4", "this is content for avn;arb 4", 4));
        list.add(new Note("Title 5", "this is content for 5", 5));
        list.add(new Note("Title 6", "this is content for 6", 6));
        list.add(new Note("Title 7", "this is content for 7", 7));
        list.add(new Note("Title 8", "this is content forzdfkajerb 8", 8));
        list.add(new Note("Title 9", "this is content for 9", 9));
        list.add(new Note("Title 10", "this is content for 10", 10));
        list.add(new Note("Title 11", "this is content foadfbakjfa er;r 11", 11));
        list.add(new Note("Title 12", "this is content for 12", 12));
        list.add(new Note("Title 13", "this is content for 13", 13));
        list.add(new Note("Title 14", "this is contentzdfbsdf a tqen for 14", 14));
        list.add(new Note("Title 15", "this is content for 15", 15));
        list.add(new Note("Title 16", "this is content for 16", 16));

        return list;
    }

    @Override
    protected void onResume() {
        dbAdapter.openDB();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dbAdapter.closeDB();
        super.onPause();
    }
}
