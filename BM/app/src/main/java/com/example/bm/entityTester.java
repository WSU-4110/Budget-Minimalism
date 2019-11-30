package com.example.bm;

import android.app.Activity;

import junit.framework.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



public class entityTester {
    // This class will test the database methods I implemented from Android Room


    protected void assertDefaultDescription() {
        transactionEntity transaction = new transactionEntity();
        assertTrue(transaction.getDescription() == "NULL");
    }

    protected void assertPassedString() {
        transactionEntity transaction1 = new transactionEntity("parameter");
        assertTrue(transaction1.getDescription() == "parameter");
    }
}
