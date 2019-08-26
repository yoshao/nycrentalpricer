package com.example.nycrentalpricer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        if(getIntent().hasExtra("com.example.rent2.SOMETHING")){
            TextView tv = (TextView) findViewById(R.id.priceTextView);
            String text = "Predicted rent: $" + getIntent().getExtras().getString("com.example.rent2.SOMETHING");
            tv.setText(text);
        }

        if(getIntent().hasExtra("com.example.rent2.SOMETHING2")){
            TextView tv2 = (TextView) findViewById(R.id.MedianTextView);
            String text2 = "Median rent: $" + getIntent().getExtras().getString("com.example.rent2.SOMETHING2");
            tv2.setText(text2);
        }

        /**
        if (getIntent().hasExtra("resultString")){
            TextView tv = (TextView) findViewById(R.id.priceTextView);
            String text = getIntent().getExtras().getString("resultString");
            tv.setText(text);
        }
         */
    }
}
