package com.example.russianidioms.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RussianIdiomsDbOpenHelper extends SQLiteOpenHelper {
    public RussianIdiomsDbOpenHelper(@Nullable Context context) {
        super(context,
                RussionIdiomsReaderContract.DATABASE_NAME,
                null, //cursor
                RussionIdiomsReaderContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME + " (" +
                        RussionIdiomsReaderContract.DicOfIdioms.COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "  +
                        RussionIdiomsReaderContract.DicOfIdioms.COLUMN_NAME + "TEXT NOT NULL, "  +
                        RussionIdiomsReaderContract.DicOfIdioms.COLUMN_MEANING + "TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //need to change
        db.execSQL(
                "DROP TABLE IF EXISTS " + RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME + " ;"
        );
        onCreate(db);
    }
}
