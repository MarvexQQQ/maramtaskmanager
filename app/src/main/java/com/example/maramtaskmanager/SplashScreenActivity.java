package com.example.maramtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        img1=findViewById(R.id.img1);


        Thread th= new Thread(){
            @Override
            public void run() {
                // here is the part that will run while others are running
                int i =3*1000;
                try {
                    sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}