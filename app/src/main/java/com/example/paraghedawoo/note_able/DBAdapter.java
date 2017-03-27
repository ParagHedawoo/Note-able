package com.example.paraghedawoo.note_able;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.example.paraghedawoo.note_able.DBStrings.Note.COLUMN_CONTENT;
import static com.example.paraghedawoo.note_able.DBStrings.Note.COLUMN_TITLE;
import static com.example.paraghedawoo.note_able.DBStrings.Note.TABLE_NAME;
import static com.example.paraghedawoo.note_able.DBStrings.Note._ID;
import static com.example.paraghedawoo.note_able.MainActivity.noteList;

/**
 * Created by Parag Hedawoo on 3/23/2017.
 */

public class DBAdapter {

    private static SQLiteDatabase db;
    private static DBSQLiteHelper helper;
    static String[] columns = {_ID, DBStrings.Note.COLUMN_TITLE, DBStrings.Note.COLUMN_CONTENT};

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
        Cursor c = db.query(DBStrings.Note.TABLE_NAME, columns, _ID+ "=" + insertNote , null, null, null, null);
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
            Log.i("id", String.valueOf(cursor.getInt(0)));
            Log.i("Note", cursor.getString(1));
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

    public static Note getNote(int id) {
        db = helper.getReadableDatabase();

        Cursor cursor = db.query(DBStrings.Note.TABLE_NAME, new String[] { _ID,
                        COLUMN_TITLE, COLUMN_CONTENT }, _ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Note note = new Note(cursor.getString(1), cursor.getString(2), cursor.getInt(0));
        // return contact
        return note;
    }

    public void deleteNote(int id) {
        db = helper.getWritableDatabase();
        db.delete(TABLE_NAME, _ID + "=?" + id+1, new String[]{Integer.toString(id)});
        db.execSQL("UPDATE " + TABLE_NAME + " SET " + _ID + " = " +
                _ID + " -1 " + " WHERE " + _ID + " > " + id + ";");
    }

}
