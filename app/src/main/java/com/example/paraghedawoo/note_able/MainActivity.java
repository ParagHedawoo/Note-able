package com.example.paraghedawoo.note_able;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getApplicationContext()).setView(R.layout.new_note_dialog).setCancelable(true).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        List<Note> noteList = getListItemData();
        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, noteList);
        recyclerView.setAdapter(adapter);
    }

    public void createNote(View view){
        startActivity(new Intent(getApplicationContext(), NewNote.class));
    }

    public void photo(View view){
        Toast.makeText(getApplicationContext(), "new photo tapped", Toast.LENGTH_SHORT).show();
    }

    public void reminder(View view){
        Toast.makeText(getApplicationContext(), "new reminder tapped", Toast.LENGTH_SHORT).show();
    }

    public void recording(View view){
        Toast.makeText(getApplicationContext(), "new recording tapped", Toast.LENGTH_SHORT).show();
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

}
