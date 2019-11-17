package com.example.bm;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


// Mitchell
// This is an "Entity" for user input in the SQLite database
@Entity(tableName = "transaction_table")
public class transactionEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "transactionEntity")
    private String description;
    //@ColumnInfo(name = "amount")
    //private String amount;

    // Default constructor
    public transactionEntity() {
        this.description = "NULL";
       //this.amount = "NULL";
    }

    // Parameterized constructor
    public transactionEntity(@NonNull String passedDescription) {
        this.description = passedDescription;
    }

    // Mitchell
    public void setDescription(@NonNull String passedDescription){
        this.description = passedDescription;
    }

    // Mitchell
    @NonNull
    public String getDescription() {
        return this.description;
    }

    /* Uncomment after learning more about columns
    public void setAmount(@NonNull String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return this.transactionEntity;
    }
    */
}