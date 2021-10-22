package com.example.bm;

import static org.junit.Assert.*;

import org.junit.Test;

public class transactionTest {

    transaction test = new transaction();
    public void setParam()
    {
        test.setId("1023");
        test.setDescription("Unit Testing Going On");
        test.setPrice("7.09$");
        test.setCategory("Bill");
    }
    @Test
    public void getId() {
        setParam();
        assertEquals("1023", test.getId());  //Positive testing
        assertNotSame("122",test.getId());  // Negative testing
    }

    @Test
    public void getDescription() {
        setParam();
        assertEquals("Unit Testing Going On", test.getDescription());  //Positive testing
        assertNotSame("Hello World",test.getDescription());  // Negative testing
    }

    @Test
    public void getPrice() {
        setParam();
        assertEquals("7.09$", test.getPrice());  //Positive testing
        assertNotSame("3.00$",test.getPrice());  // Negative testing
    }

    @Test
    public void validatePrice()
    {
        assertTrue(test.validatePrice("7.09"));    //Positive testing
        assertFalse(test.validatePrice("Random String"));  // Negative testing
    }

    @Test
    public void getCategory() {
        setParam();
        assertEquals("Bill", test.getCategory());  //Positive testing
        assertNotSame("Travel",test.getCategory());  // Negative testing
    }

    @Test
    public void checkNull()
    {
        assertTrue(test.checkNull());  //Positive Testing

        setParam();
        assertFalse(test.checkNull());  //Negative Testing
    }
}