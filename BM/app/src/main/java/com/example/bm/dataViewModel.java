package com.example.bm;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class dataViewModel extends AndroidViewModel {


    private transactionRepository repositoryObject;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<transactionEntity>> allTransactionObjects;
    private LiveData<java.lang.Double> totalExpense = null;

    public dataViewModel(Application application) {
        super(application);
        repositoryObject = new transactionRepository(application);
        allTransactionObjects = repositoryObject.getAllWords();
        totalExpense = repositoryObject.getTotalExpense();
    }

    LiveData<List<transactionEntity>> getAllWords() {
        return allTransactionObjects;
    }

    public LiveData<java.lang.Double> getTotalExpense(){
        return totalExpense;
    }

    void insert(transactionEntity transactionEntity) {
        repositoryObject.insert(transactionEntity);
    }
}
