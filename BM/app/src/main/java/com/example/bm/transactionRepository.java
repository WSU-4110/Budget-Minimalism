package com.example.bm;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class transactionRepository {
    private dataDAO mitchDAO;
    private LiveData<List<transactionEntity>> allTransactionObjects;

    transactionRepository(Application application) {
        transactionDatabase db = transactionDatabase.getDatabase(application);
        mitchDAO = db.dataDAO();
        allTransactionObjects = mitchDAO.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<transactionEntity>> getAllWords() {
        return allTransactionObjects;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(transactionEntity transactionEntity) {
        transactionDatabase.databaseWriteExecutor.execute(() -> {
            mitchDAO.insert(transactionEntity);
        });
    }
}
