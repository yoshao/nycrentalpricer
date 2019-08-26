package com.example.rent2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(getIntent().hasExtra("com.example.rent2.SOMETHING")){
            TextView tv = (TextView) findViewById(R.id.result);
            String text = getIntent().getExtras().getString("com.example.rent2.SOMETHING");
            tv.setText(text);
        }

        if(getIntent().hasExtra("com.example.rent2.SOMETHING2")){
            TextView tv2 = (TextView) findViewById(R.id.medianprice);
            String text2 = getIntent().getExtras().getString("com.example.rent2.SOMETHING2");
            tv2.setText(text2);
        }

    }
}
