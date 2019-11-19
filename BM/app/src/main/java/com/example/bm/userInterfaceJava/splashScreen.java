package com.example.bm;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {

    // Nahidul:
    // Initialize the variable which determines splash screen time
    private int SLEEP_TIMER=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Nahidul
        // This function makes this activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();





    }

    // Nahidul:
    private class LogoLauncher extends Thread{

        public void run(){

            try{
                // Nahidul:
                // Time that splash screen is displayed
                sleep(1000*SLEEP_TIMER);

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent =new Intent(splashScreen.this, mainActivity.class);

            startActivity(intent);
            splashScreen.this.finish();


        }



    }
}
