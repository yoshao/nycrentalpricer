package com.example.rent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.nio.charset.Charset.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readData();

        final Button secondActivityBtn = (Button) findViewById(R.id.button2);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.editText);
                String result = firstNumEditText.getText().toString();
                String theprice = rentSamples2.get(result).substring(0,4);
                String medianprice = rentSamples2.get(result).substring(4,8);
                Intent startIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startIntent.putExtra("com.example.rent2.SOMETHING", theprice);
                startIntent.putExtra("com.example.rent2.SOMETHING2", medianprice);
                startActivity(startIntent);
            }
        });
    }

    private List<DataSample> rentSamples = new ArrayList<>();
    private HashMap<String, String> rentSamples2 = new HashMap<>();

    private void readData() {
        InputStream is = getResources().openRawResource(R.raw.data2);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, forName("UTF-8"))
        );

        String line = "";
        try {
            //strop over headers
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                //split by ','
                String[] tokens = line.split(",");

                //read the data
                DataSample sample = new DataSample();
                sample.setFeatures(tokens[0]);
                sample.setPrice(tokens[1]);
                sample.setMedianprice(tokens[2]);
                rentSamples.add(sample);
                rentSamples2.put(tokens[0],tokens[1]+tokens[2]);

                Log.d("MyActivity", "Just created" + sample);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error message" + line,e);
            e.printStackTrace();
            }
        }
}
