package com.sagar.android.roomtestexample;

import android.os.AsyncTask;
import android.support.annotation.NonNull;


public class DatabaseInitializer {

    public static void populatAsync(@NonNull final AppDatabase db, User user) {
        PopulateDbAsync task = new PopulateDbAsync(db, user);
        task.execute();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;
        private final User mUser;

        PopulateDbAsync(AppDatabase db, User user) {
            mDb = db;
            mUser = user;

        }

        @Override
        protected Void doInBackground(Void... voids) {
            populateWithData(mDb, mUser);
            return null;
        }

        private static void populateWithData(AppDatabase mDb, User mUser) {
            mDb.userDao().insertAll(mUser);
        }
    }
}
