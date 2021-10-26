package com.example.bm;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


// Mitchell
// This is an "Entity" for user input in the SQLite database
@Entity(tableName = "transaction_table")
public class transactionEntity {


    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "transactionEntity")
    private String description;
    private String type;
    private double amount;
    private String date;
    private int transactionType;

    // Default constructor
    public transactionEntity() {
        this.description = "NULL";
        //this.amount = "NULL";
    }

    public transactionEntity(@NonNull String passedDescription, String type, double amount, String date, int transactionType) {
        this.description = passedDescription;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
    }

    // Parameterized constructor
    public transactionEntity(@NonNull String passedDescription) {
        this.description = passedDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }



    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }


    //@ColumnInfo(name = "amount")
    //private String amount;



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