package com.example.paraghedawoo.note_able;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

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
        super.onBackPressed();
    }

}
