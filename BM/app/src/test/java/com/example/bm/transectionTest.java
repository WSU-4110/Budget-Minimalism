package com.example.bm;

import com.example.bm.userInterfaceJava.pricecheck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;



import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class transectionTest {
    private pricecheck view;

    transection tran=new transection();
    @Test
    public void getId() {



        String input="testid";
        String output;
        String expected="testid";

        tran.setId(input);
        output=tran.getId();
        assertEquals(expected,output);
    }

    @Test
    public void getDescription() {



        String input="testdescription";
        String output;
        String expected="testdescription";

        tran.setDescription(input);
        output=tran.getDescription();
        assertEquals(expected,output);
    }



    @Test
    public void getPrice() {

        String input="100";
        String output;
        String expected="100";

        tran.setPrice(input);
        output=tran.getPrice();
        assertEquals(expected,output);


    }




    @Test
    public void getCategory() {



        String input="testcategory";
        String output;
        String expected="testcategory";

        tran.setCategory(input);
        output=tran.getCategory();
        assertEquals(expected,output);
    }
    @Test
    public void checkuserinput(){
        transection tran1=new transection("1101","description","1000","rent");
        transection tran2=new transection("1101","description","2000","rent");
        String output;
        output=tran1.getPrice()+tran2.getPrice();
        String expected="10002000";

        assertEquals(expected,output);




    }


public void startprice (){

}



}