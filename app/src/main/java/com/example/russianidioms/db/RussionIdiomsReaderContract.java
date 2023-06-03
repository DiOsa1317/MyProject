package com.example.russianidioms.db;

public class RussionIdiomsReaderContract {
    public static final String DATABASE_NAME = "RussionIdioms.db";
    public static final int DATABASE_VERSION = 21;

    private RussionIdiomsReaderContract() {}

    public static class DicOfIdioms {
        public static final String TABLE_NAME = "Idioms";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME= "name";
        public static final String COLUMN_MEANING = "meaning";
        public static final String COLUMN_HISTORY = "history";

        public static final String LOG_TAG = "log_tag";
    }

    public static class DicOfDrWords {
        public static final String TABLE_NAME = "DrWords";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME= "name";
        public static final String COLUMN_MEANING = "meaning";
        public static final String COLUMN_HISTORY = "history";

        public static final String LOG_TAG = "log_tag";
    }

    public static class IdiomTests {
        public static final String TABLE_NAME = "IdiomTests";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_THEME= "theme";
        public static final String COLUMN_VARIENT1 = "varient1";
        public static final String COLUMN_VARIENT2 = "varient2";
        public static final String COLUMN_VARIENT3 = "varient3";
        public static final String COLUMN_VARIENT4 = "varient4";
        public static final String COLUMN_PROBLEM = "problem";


        public static final String LOG_TAG = "log_tag";
    }
}
