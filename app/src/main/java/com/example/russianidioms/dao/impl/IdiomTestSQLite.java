package com.example.russianidioms.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.russianidioms.dao.IdiomTestsDao;
import com.example.russianidioms.dao.RussionIdiomsDao;
import com.example.russianidioms.db.IdiomTestOpenHelper;
import com.example.russianidioms.db.RussionIdiomsReaderContract;
import com.example.russianidioms.domain.IdiomTest;
import com.example.russianidioms.domain.WordFromDic;
import com.example.russianidioms.domain.WordFromIdiomDIc;

import java.util.ArrayList;
import java.util.List;

public class IdiomTestSQLite implements IdiomTestsDao {
    private  final IdiomTestOpenHelper openHelper;

    public IdiomTestSQLite(Context context) {
        this.openHelper = new IdiomTestOpenHelper(context);
    }

    @Override
    public long insert(IdiomTest idiomTest) {
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(
                RussionIdiomsReaderContract.IdiomTests.COLUMN_THEME, idiomTest.getTheme()
        );
        contentValues.put(
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT1, idiomTest.getVarient1()
        );
        contentValues.put(
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT2, idiomTest.getVarient2()
        );
        contentValues.put(
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT3, idiomTest.getVarient3()
        );
        contentValues.put(
                RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT4, idiomTest.getVarient4()
        );
        contentValues.put(
                RussionIdiomsReaderContract.IdiomTests.COLUMN_PROBLEM, idiomTest.getProblem()
        );
        long insert = sqLiteDatabase.insert(
                RussionIdiomsReaderContract.IdiomTests.TABLE_NAME,
                null,
                contentValues
        );
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.IdiomTests.LOG_TAG, "inserted " + insert);
        return insert;
    }

    @Override
    public List<IdiomTest> findAll() {
        SQLiteDatabase sqLiteDatabase = openHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query( //select
                RussionIdiomsReaderContract.IdiomTests.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        List<IdiomTest> test = new ArrayList<>();
        if(cursor.moveToFirst()) {
            int id = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_ID);
            int theme = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_THEME);
            int varient1 = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT1);
            int varient2 = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT2);
            int varient3 = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT3);
            int varient4 = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT4);
            int problem = cursor.getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_PROBLEM);

            do {
                IdiomTest idiomTest = new IdiomTest(
                        cursor.getLong(id),
                        cursor.getString(theme),
                        cursor.getString(varient1),
                        cursor.getString(varient2),
                        cursor.getString(varient3),
                        cursor.getString(varient4),
                        cursor.getInt(problem)

                );
                test.add(idiomTest);
            }while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.IdiomTests.LOG_TAG, "In db:\n" + test.toString());
        return test;
    }

    @Override
    public IdiomTest findById(long id) {
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                RussionIdiomsReaderContract.IdiomTests.TABLE_NAME,
                null,
                RussionIdiomsReaderContract.IdiomTests.COLUMN_ID + " ?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()) {

            int columnIndexName = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_THEME);
            int columnIndexVarient1 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT1);
            int columnIndexVarient2 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT2);
            int columnIndexVarient3 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT3);
            int columnIndexVarient4 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT4);
            int columnIndexProblem = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_PROBLEM);
            IdiomTest idiomTest = new IdiomTest(
                    id,
                    cursor.getString(columnIndexName),
                    cursor.getString(columnIndexVarient1),
                    cursor.getString(columnIndexVarient2),
                    cursor.getString(columnIndexVarient3),
                    cursor.getString(columnIndexVarient4),
                    cursor.getInt(columnIndexProblem)
            );

            cursor.close();
            readableDatabase.close();
            Log.i(RussionIdiomsReaderContract.IdiomTests.LOG_TAG, "Found student: \n" + idiomTest.toString());
            return idiomTest;
        }
        cursor.close();
        readableDatabase.close();
        return null;
    }

    @Override
    public int update(long id, IdiomTest test) {
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        int k = 0;
        Cursor cursor = writableDatabase.query(
                RussionIdiomsReaderContract.IdiomTests.TABLE_NAME,
                null,
                RussionIdiomsReaderContract.IdiomTests.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
        if (cursor.moveToFirst()) {//установка на первую строчку
            int columnIndexName = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_THEME);
            int columnIndexVarient1 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT1);
            int columnIndexVarient2 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT2);
            int columnIndexVarient3 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT3);
            int columnIndexVarient4 = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_VARIENT4);
            int columnIndexProblem = cursor
                    .getColumnIndex(RussionIdiomsReaderContract.IdiomTests.COLUMN_PROBLEM);
            IdiomTest idiomTest = new IdiomTest(
                    id,
                    cursor.getString(columnIndexName),
                    cursor.getString(columnIndexVarient1),
                    cursor.getString(columnIndexVarient2),
                    cursor.getString(columnIndexVarient3),
                    cursor.getString(columnIndexVarient4),
                    cursor.getInt(columnIndexProblem)
            );

            if (test.getTheme() != idiomTest.getTheme()) {
                test.setTheme(idiomTest.getTheme());
                k++;
            }
            if (test.getVarient1() != idiomTest.getVarient1()) {
                test.setVarient1(idiomTest.getVarient1());
                k++;
            }
            if (test.getVarient2() != idiomTest.getVarient2()) {
                test.setVarient2(idiomTest.getVarient2());
                k++;
            }
            if (test.getVarient3() != idiomTest.getVarient3()) {
                test.setVarient3(idiomTest.getVarient3());
                k++;
            }
            if (test.getVarient4() != idiomTest.getVarient4()) {
                test.setVarient4(idiomTest.getVarient4());
                k++;
            }
            writableDatabase.close();
            cursor.close();
            Log.i(RussionIdiomsReaderContract.IdiomTests.LOG_TAG, "Update test: + " + test);
        }
        return k;
    }



    @Override
    public int deleteById(long id) {
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
        int delete= sqLiteDatabase.delete(
                RussionIdiomsReaderContract.IdiomTests.TABLE_NAME,
                RussionIdiomsReaderContract.IdiomTests.COLUMN_ID + " = ?",
                new String[] {String.valueOf(id)}
        );
        sqLiteDatabase.close();
        Log.i(RussionIdiomsReaderContract.IdiomTests.LOG_TAG, "Deleted " + delete);
        return delete;
    }
}
