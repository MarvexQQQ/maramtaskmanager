package com.example.maramtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class addtaskactivity extends AppCompatActivity {
    private TextInputEditText tl,sub;
    private Button btn;
    private ImageView img;
    private Button btn0;
    private Spinner nec;
    private SeekBar sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtaskactivity);
        tl=findViewById(R.id.tl);
        sub=findViewById(R.id.sub);
        btn0=findViewById(R.id.btn0);
        nec=findViewById(R.id.nec);
        sb=findViewById(R.id.sb);
    }
}