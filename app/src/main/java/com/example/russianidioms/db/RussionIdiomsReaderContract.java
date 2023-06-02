package com.example.russianidioms.db;

public class RussionIdiomsReaderContract {
    public static final String DATABASE_NAME = "RussionIdioms.db";
    public static final int DATABASE_VERSION = 1;

    private RussionIdiomsReaderContract() {}

    public static class DicOfIdioms {
        public static final String TABLE_NAME = "Idioms";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME= "name";
        public static final String COLUMN_MEANING = "meaning";
        public static final String LOG_TAG = "log_tag";
    }
}
