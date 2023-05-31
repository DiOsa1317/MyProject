package com.example.russianidioms.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.russianidioms.db.RussianIdiomsDbOpenHelper;
import com.example.russianidioms.db.RussionIdiomsReaderContract;
import com.example.russianidioms.domain.WordFromDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.ArrayList;
import java.util.List;

public class WordFromIdiomDicSQLite implements RussionIdiomsDao{

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
        return wordsFromDic;
    }

    @Override
    public WordFromDic findById(long id) {
        return null;
    }

    @Override
    public int update(long id, WordFromDic wordFromDic) {
        return 0;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }
}
