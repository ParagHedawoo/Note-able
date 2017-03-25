package com.example.paraghedawoo.note_able;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parag Hedawoo on 3/23/2017.
 */

public class DBAdapter {

    private static SQLiteDatabase db;
    private DBSQLiteHelper helper;
    static String[] columns = {DBStrings.Note._ID, DBStrings.Note.COLUMN_TITLE, DBStrings.Note.COLUMN_CONTENT};

    public DBAdapter(Context c){
        helper = new DBSQLiteHelper(c);
    }

    public void openDB() throws SQLException {
        db = helper.getWritableDatabase();
    }

    public void closeDB(){
            helper.close();
    }

    public Note addNewNote(String title, String content){
        ContentValues cv = new ContentValues();
        cv.put(DBStrings.Note.COLUMN_TITLE, title);
        cv.put(DBStrings.Note.COLUMN_CONTENT, content);
        long insertNote = db.insert(DBStrings.Note.TABLE_NAME, null, cv);
        Cursor c = db.query(DBStrings.Note.TABLE_NAME, columns, DBStrings.Note._ID+ "=" + insertNote , null, null, null, null);
        c.moveToFirst();
        Note newNote = cursorToNote(c);
        c.close();
        return newNote;
    }

    public static List<Note> getAllNotes(){
        List<Note> notes = new ArrayList<>();
        Cursor cursor = db.query(DBStrings.Note.TABLE_NAME, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Note note = cursorToNote(cursor);
            notes.add(note);
            cursor.moveToNext();
        }
        cursor.close();
        return notes;
    }

    private static Note cursorToNote(Cursor cursor){
        Note note = new Note();
        note.setId(cursor.getInt(0));
        note.setTitle(cursor.getString(1));
        note.setContent(cursor.getString(2));
        return note;
    }

}
