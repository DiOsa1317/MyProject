package com.example.russianidioms.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DrDbOpenHelper extends SQLiteOpenHelper {
    public DrDbOpenHelper(@Nullable Context context) {
        super(context,
                RussionIdiomsReaderContract.DATABASE_NAME,
                null, //cursor
                RussionIdiomsReaderContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME + " (" +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY + " TEXT NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //need to change
        db.execSQL(
                "DROP TABLE IF EXISTS " + RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME + " ;"
        );
        onCreate(db);
    }


}
