package com.example.russianidioms.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.russianidioms.dao.RussionIdiomsDao;
import com.example.russianidioms.db.DrDbOpenHelper;
import com.example.russianidioms.db.RussionIdiomsReaderContract;
import com.example.russianidioms.domain.WordFromDic;
import com.example.russianidioms.domain.WordFromDrDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.ArrayList;
import java.util.List;

public class WordFromDrDicSQLite implements RussionIdiomsDao {
    private  final DrDbOpenHelper openHelper;

    public WordFromDrDicSQLite(Context context) {
        this.openHelper = new DrDbOpenHelper(context);
    }

    @Override
    public long insert(WordFromDic wordFromDic) {
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME, wordFromDic.getName()
        );
        contentValues.put(
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING, wordFromDic.getMeaning()
        );
        contentValues.put(
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY, wordFromDic.getHistory()
        );
        long insert = sqLiteDatabase.insert(
                RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME,
                null,
                contentValues
        );
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.DicOfDrWords.LOG_TAG, "inserted " + insert);
        return insert;
    }

    @Override
    public List<WordFromDic> findAll() {
        SQLiteDatabase sqLiteDatabase = openHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query( //select
                RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        List<WordFromDic> wordsFromDic = new ArrayList<>();
        if(cursor.moveToFirst()) {
            int id = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_ID);
            int name = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME);
            int meaning = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING);
            int history = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY);

            do {
                WordFromDrDic wordFromDrDic = new WordFromDrDic(
                        cursor.getLong(id),
                        cursor.getString(name),
                        cursor.getString(meaning),
                        cursor.getString(history)
                );
                wordsFromDic.add(wordFromDrDic);
            }while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.DicOfDrWords.LOG_TAG, "In db:\n" + wordsFromDic.toString());
        return wordsFromDic;
    }

    @Override
    public WordFromDic findById(long id) {
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME,
                null,
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_ID + " ?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()) {

            int columnIndexName = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME);
            int columnIndexMeaning = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING);
            int columnIndexHistory = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY);
            WordFromDrDic wordFromDrDic = new WordFromDrDic(
                    id,
                    cursor.getString(columnIndexName),
                    cursor.getString(columnIndexMeaning),
                    cursor.getString(columnIndexHistory)
            );

            cursor.close();
            readableDatabase.close();
            Log.i(RussionIdiomsReaderContract.DicOfDrWords.LOG_TAG, "Found student: \n" + wordFromDrDic.toString());
            return wordFromDrDic;
        }
        cursor.close();
        readableDatabase.close();
        return null;
    }

    @Override
    public int update(long id, WordFromDic wordFromDic) {
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        int k = 0;
        Cursor cursor = writableDatabase.query(
                RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME,
                null,
                RussionIdiomsReaderContract.DicOfIdioms.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()) {//установка на первую строчку
            int colunmnIndexName = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_NAME);
            int colunmnIndexMeaning = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_MEANING);
            int columnIndexHistory = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.DicOfDrWords.COLUMN_HISTORY);
            WordFromIdiomDIc wordFromIdiomDIc = new WordFromIdiomDIc(
                    id,
                    cursor.getString(colunmnIndexName),
                    cursor.getString(colunmnIndexMeaning),
                    cursor.getString(columnIndexHistory)
            );
            if (wordFromIdiomDIc.getName() != wordFromDic.getName()) {
                wordFromIdiomDIc.setName(wordFromDic.getName());
                k++;
            }
            if (wordFromIdiomDIc.getMeaning() != wordFromDic.getMeaning()) {
                wordFromIdiomDIc.setMeaning(wordFromDic.getMeaning());
                k++;
            }
            if (wordFromIdiomDIc.getHistory() != wordFromDic.getHistory()) {
                wordFromIdiomDIc.setHistory(wordFromDic.getHistory());
                k++;
            }
            writableDatabase.close();
            cursor.close();
            Log.i(RussionIdiomsReaderContract.DicOfDrWords.LOG_TAG, "Update wordFromIdiomDic: + " + wordFromIdiomDIc);
        }
        return k;
    }



    @Override
    public int deleteById(long id) {
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
        int delete= sqLiteDatabase.delete(
                RussionIdiomsReaderContract.DicOfDrWords.TABLE_NAME,
                RussionIdiomsReaderContract.DicOfDrWords.COLUMN_ID + " = ?",
                new String[] {String.valueOf(id)}
        );
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.DicOfDrWords.LOG_TAG, "Deleted " + delete);
        return delete;
    }
}
