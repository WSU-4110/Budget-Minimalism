//
// This code is setup as an attempt to make an SQlite database
// Its not working so well, we will probably pivot to firebase


package com.example.bm;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    // One column for Descriptions, one for Amounts, table is named "Transactions"
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Transactions";
    private static final String COL1 = "Description";
    private static final String COL2 = "Amount";
    private static final String COL3 = "Category";


    // Default constructor
    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase mitchDB) {
        /*
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        mitchDB.execSQL(createTable);
        */

    }

    @Override
    public void onUpgrade(SQLiteDatabase mitchDB, int i, int j) {
        mitchDB.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(mitchDB);
    }

    void addData(String item) {
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        //Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = mitchDB.insert(TABLE_NAME, null, contentValues);
    }

    Cursor getData(){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor datuh = mitchDB.rawQuery(query, null);
        return datuh;
    }

    Cursor getItem(String str){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + str + "'";
        Cursor data = mitchDB.rawQuery(query, null);
        return data;
    }


    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        mitchDB.execSQL(query);
    }


    public void delete(int id, String amount){
        SQLiteDatabase mitchDB = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + amount + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + amount + " from database.");
        mitchDB.execSQL(query);
    }
}
