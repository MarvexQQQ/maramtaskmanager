package com.example.maramtaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private SearchView hs;
    private ListView HL;
    private FloatingActionButton prsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prsb=findViewById(R.id.prsb);
        hs=findViewById(R.id.hs);
        HL=findViewById(R.id.Hl);

    }
}