package com.example.nycrentalpricer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if (getIntent().hasExtra("resultPrice")){
            TextView tv = (TextView) findViewById(R.id.priceTextView);
            String text = getIntent().getExtras().getString("resultPrice");
            tv.setText(text);
        }
    }
}
