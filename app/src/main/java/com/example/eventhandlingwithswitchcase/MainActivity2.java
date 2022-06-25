package com.example.eventhandlingwithswitchcase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = (EditText) findViewById(R.id.showTotal);
        et1.setText(getIntent().getExtras().getString("key1"));
    }
}