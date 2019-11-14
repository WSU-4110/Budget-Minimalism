package com.example.bm;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Transactions";
    private static final String COL1 = "Description";
    private static final String COL2 = "Amount";


    // Constructor
    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase mitchDB) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        mitchDB.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase mitchDB, int i, int j) {
        mitchDB.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(mitchDB);
    }

    public boolean addData(String item) {
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = mitchDB.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        return result != -1;
    }

    public Cursor getData(){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = mitchDB.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = mitchDB.rawQuery(query, null);
        return data;
    }

    /**

     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
*/
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        mitchDB.execSQL(query);
    }
/**
     * Delete from database
     * @param id
     * @param name
*/
    public void deleteName(int id, String name){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        mitchDB.execSQL(query);
    }
}
