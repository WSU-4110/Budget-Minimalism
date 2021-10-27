package com.example.bm;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Mitchell
// This is the backend, you don't need to mess around in here directly

@Database(entities = {transactionEntity.class}, version = 3, exportSchema = false)
public abstract class transactionDatabase extends RoomDatabase {

    public abstract dataDAO dataDAO();

    private static volatile transactionDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static transactionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (transactionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            transactionDatabase.class, "transaction_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public dataDAO getDataDao()
    {
        return INSTANCE.dataDAO();
    }
    // Mitchell
    // overrides onOpen to populate the database
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                dataDAO dao = INSTANCE.dataDAO();
                dao.deleteAll();


                //transactionEntity word = new transactionEntity("testing purposes");
                //dao.insert(word);


            });
        }
    };
}

