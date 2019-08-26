package com.example.nycrentalpricer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //protected String bed, bath, type, hood, month;

    protected String bed = "1";
    protected String bath = "1";
    protected String type = "Rental Unit";
    protected String hood = "Williamsburg";
    protected String month = "1";

    protected String transit = "0";
    protected String  amenities = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readData();

        Button enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListenerOnButton();
                String result = bed + bath + transit + amenities + hood + type;
                String theprice = rentSamples2.get(result).substring(0,4);
                String medianprice = rentSamples2.get(result).substring(4,8);
                Intent outputIntent = new Intent(getApplicationContext(), ResultActivity.class);
                outputIntent.putExtra("com.example.rent2.SOMETHING", theprice);
                outputIntent.putExtra("com.example.rent2.SOMETHING2", medianprice);


                //outputIntent.putExtra("resultString",bed + bath + transit + amenities + hood + type);
                //outputIntent.putExtra("monthString",month);

                startActivity(outputIntent);




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
    public void addListenerOnButton(){


        CheckBox doorman_cb = (CheckBox) findViewById(R.id.doorman_cb);
        CheckBox gym_cb = (CheckBox) findViewById(R.id.gym_cb);
        CheckBox transit_cb = (CheckBox) findViewById(R.id.transit_cb);
        CheckBox wd_cb = (CheckBox) findViewById(R.id.wd_cb);
        CheckBox furnished_cb = (CheckBox) findViewById(R.id.furnished_cb);

        int transit_i = transit_cb.isChecked() ? 1 : 0;
        transit = "" + transit_i;
        int doorman = doorman_cb.isChecked() ? 1 : 0;
        int gym = gym_cb.isChecked() ? 1 : 0;
        int wd = wd_cb.isChecked() ? 1 : 0;
        int furnished = furnished_cb.isChecked() ? 1 : 0;
        int amenities_i = doorman + gym + wd + furnished;
        amenities = "" + amenities_i;

        Spinner bed_s = (Spinner) findViewById(R.id.bed_s);
        Spinner bath_s = (Spinner) findViewById(R.id.bath_s);
        Spinner hood_s = (Spinner) findViewById(R.id.hood_s);
        Spinner type_s = (Spinner) findViewById(R.id.type_s);
        Spinner movein_s = (Spinner) findViewById(R.id.movein_s);

        bed = bed_s.getSelectedItem().toString();
        bath = bath_s.getSelectedItem().toString();
        hood = hood_s.getSelectedItem().toString();
        type = type_s.getSelectedItem().toString();
        month = movein_s.getSelectedItem().toString();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
