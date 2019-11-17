package com.example.bm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface dataDAO {

    @Query("SELECT * from transaction_table ORDER BY transactionEntity")
    LiveData<List<transactionEntity>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(transactionEntity transactionEntity);

    @Query("DELETE FROM transaction_table")
    void deleteAll();

}
