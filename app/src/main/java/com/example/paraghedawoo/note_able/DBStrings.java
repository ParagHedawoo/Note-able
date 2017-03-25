package com.example.paraghedawoo.note_able;

import android.provider.BaseColumns;

/**
 * Created by Parag Hedawoo on 3/23/2017.
 */

public class DBStrings {

        private DBStrings() {
        }

        public class Note implements BaseColumns {
            public static final String TABLE_NAME = "notestable";
            public static final String COLUMN_TITLE = "title";
            public static final String COLUMN_CONTENT = "content";
            public static final String _ID = "id";


            public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_CONTENT + " TEXT" + ")";
        }
}
