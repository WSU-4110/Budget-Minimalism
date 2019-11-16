package com.example.bm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface dataDAO {

    @Query("SELECT * from description_table ORDER BY description")
    LiveData<List<description>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(description description);

    @Query("DELETE FROM description_table")
    void deleteAll();

}
