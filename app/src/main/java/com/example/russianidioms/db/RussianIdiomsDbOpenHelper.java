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
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME + " (" +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY + " TEXT NOT NULL);"
        );
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME + " (" +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY + " TEXT NOT NULL);"
        );
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RussionIdiomsReaderContract.IdiomTests.TABLE_NAME + " (" +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_THEME + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT1 + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT2 + " TEXT NOT NULL, " +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT3 + " TEXT NOT NULL , " +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT4 + " TEXT NOT NULL , " +
                RussionIdiomsReaderContract.IdiomTests.COLUMN_PROBLEM + " INTEGER NOT NULL);"
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

