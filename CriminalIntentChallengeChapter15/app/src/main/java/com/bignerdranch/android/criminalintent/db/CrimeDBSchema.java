package com.bignerdranch.android.criminalintent.db;

/**
 * Created by kyle.roe on 31/05/16.
 */
public class CrimeDBSchema {

    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT = "suspect";
            public static final String SUSPECT_NUMBER = "suspect_number";
        }
    }
}
