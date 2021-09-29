package com.example.maramtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {
    private TextView tv1,tv2;
    private Button btn1,btn2;
    private RadioGroup rg;
    private RadioButton rd1,rd2,rd3;
    private Switch st1;
    private ToggleButton tb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id. tv2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        rd1=findViewById(R.id.rd1);
        rd2=findViewById(R.id.rd2);
        rd3=findViewById(R.id.rd3);
        st1=findViewById(R.id.st1);
        tb1=findViewById(R.id.tb1);
    }
}