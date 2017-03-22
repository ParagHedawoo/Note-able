package com.example.paraghedawoo.note_able;

/**
 * Created by Parag Hedawoo on 3/16/2017.
 */

public class Note {
    public String title;
    public String content;
    public int id;

    public Note(String title, String content, int id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public Note(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
