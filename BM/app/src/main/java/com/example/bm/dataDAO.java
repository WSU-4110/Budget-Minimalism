package com.example.bm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface dataDAO {

    @Query("SELECT * from transaction_table")
    LiveData<List<transactionEntity>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(transactionEntity transactionEntity);

    @Query("DELETE FROM transaction_table")
    void deleteAll();

    @Query("SELECT * FROM transaction_table")
    List<transactionEntity> getAllTransaction();

    @Query("select sum(amount) from transaction_table where transactionType=0")
    LiveData<java.lang.Double> getTotalExpense();

}
