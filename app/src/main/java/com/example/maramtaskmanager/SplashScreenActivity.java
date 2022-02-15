package com.example.maramtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        img1=findViewById(R.id.img1);


        Thread th = new Thread() {
            @Override
            public void run() {
                // here is the part that will run while others are running
                int ms = 3 * 1000;
                try {
                    sleep(ms);
                    // check if there were a previous signing in
                    FirebaseAuth auth =FirebaseAuth.getInstance();
                    if (auth.getCurrentUser()!=null)
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    else
                        startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}