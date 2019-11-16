package com.example.bm;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


// Mitchell
// This is an "Entity" for user input in the SQLite database
@Entity(tableName = "description_table")
public class description {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    // Default constructor
    public description() {
        this.description = "NULL";
    }

    // Parameterized constructor
    public description(@NonNull String passedDescription) {
        this.description = passedDescription;
    }

    // Mitchell
    // getter
    public void setDescription(@NonNull String passedDescription){
        this.description = passedDescription;
    }

    // Mitchell
    // getter
    @NonNull
    public String getDescription() {
        return this.description;
    }
}