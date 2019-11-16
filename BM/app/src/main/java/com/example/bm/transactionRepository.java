package com.example.bm;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class transactionRepository {
    private dataDAO mitchDAO;
    private LiveData<List<description>> mAllDescriptions;

    transactionRepository(Application application) {
        transactionDatabase db = transactionDatabase.getDatabase(application);
        mitchDAO = db.dataDAO();
        mAllDescriptions = mitchDAO.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<description>> getAllWords() {
        return mAllDescriptions;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(description description) {
        transactionDatabase.databaseWriteExecutor.execute(() -> {
            mitchDAO.insert(description);
        });
    }
}
