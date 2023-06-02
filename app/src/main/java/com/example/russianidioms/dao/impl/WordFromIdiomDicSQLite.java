package com.example.russianidioms.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.russianidioms.dao.RussionIdiomsDao;
import com.example.russianidioms.db.RussianIdiomsDbOpenHelper;
import com.example.russianidioms.db.RussionIdiomsReaderContract;
import com.example.russianidioms.domain.WordFromDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.ArrayList;
import java.util.List;

public class WordFromIdiomDicSQLite implements RussionIdiomsDao {

    private  final RussianIdiomsDbOpenHelper openHelper;

    public WordFromIdiomDicSQLite(Context context) {
        this.openHelper = new RussianIdiomsDbOpenHelper(context);
    }

    @Override
    public long insert(WordFromDic wordFromDic) {
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(
                RussionIdiomsReaderContract.DicOfIdioms.COLUMN_NAME, wordFromDic.getName()
        );
        contentValues.put(
                RussionIdiomsReaderContract.DicOfIdioms.COLUMN_MEANING, wordFromDic.getMeaning()
        );
        long insert = sqLiteDatabase.insert(
                RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME,
                null,
                contentValues
        );
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.DicOfIdioms.LOG_TAG, "inserted " + insert);
        return insert;
    }

    @Override
    public List<WordFromDic> findAll() {
        SQLiteDatabase sqLiteDatabase = openHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query( //select
                RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME,
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
            int id = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_ID);
            int name = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_NAME);
            int meaning = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_MEANING);

            do {
                WordFromIdiomDIc wordFromIdiomDIc = new WordFromIdiomDIc(
                        cursor.getLong(id),
                        cursor.getString(name),
                        cursor.getString(meaning)
                );
                wordsFromDic.add(wordFromIdiomDIc);
            }while (cursor.moveToNext());
        }
        cursor.close();;
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.DicOfIdioms.LOG_TAG, "In db:\n" + wordsFromDic.toString());
        return wordsFromDic;
    }

    @Override
    public WordFromDic findById(long id) {
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME,
                null,
                RussionIdiomsReaderContract.DicOfIdioms.COLUMN_ID + " ?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()) {

            int columnIndexName = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_NAME);
            int columnIndexMeaning = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_MEANING);

            WordFromIdiomDIc wordFromIdiomDIc = new WordFromIdiomDIc(
                    id,
                    cursor.getString(columnIndexName),
                    cursor.getString(columnIndexMeaning)
            );

            cursor.close();
            readableDatabase.close();
            Log.i(RussionIdiomsReaderContract.DicOfIdioms.LOG_TAG, "Found student: \n" + wordFromIdiomDIc.toString());
            return wordFromIdiomDIc;
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
                RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME,
                null,
                RussionIdiomsReaderContract.DicOfIdioms.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()) {//установка на первую строчку
            int colunmnIndexName = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_NAME);
            int colunmnIndexMeaning = cursor.getColumnIndex(RussionIdiomsReaderContract.DicOfIdioms.COLUMN_MEANING);
            WordFromIdiomDIc wordFromIdiomDIc = new WordFromIdiomDIc(
                    id,
                    cursor.getString(colunmnIndexName),
                    cursor.getString(colunmnIndexMeaning)
            );
            if (wordFromIdiomDIc.getName() != wordFromDic.getName()) {
                wordFromIdiomDIc.setName(wordFromDic.getName());
                k++;
            }
            if (wordFromIdiomDIc.getMeaning() != wordFromDic.getMeaning()) {
                wordFromIdiomDIc.setMeaning(wordFromDic.getMeaning());
                k++;
            }
                writableDatabase.close();
                cursor.close();
                Log.i(RussionIdiomsReaderContract.DicOfIdioms.LOG_TAG, "Update wordFromIdiomDic: + " + wordFromIdiomDIc);
            }
            return k;
        }



    @Override
    public int deleteById(long id) {
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
        int delete= sqLiteDatabase.delete(
                RussionIdiomsReaderContract.DicOfIdioms.TABLE_NAME,
                RussionIdiomsReaderContract.DicOfIdioms.COLUMN_ID + " = ?",
                new String[] {String.valueOf(id)}
        );
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.DicOfIdioms.LOG_TAG, "Deleted " + delete);
        return delete;
    }
}
