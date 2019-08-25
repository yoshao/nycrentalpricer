package com.example.nycrentalpricer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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


        Button enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListenerOnButton();
                Intent outputIntent = new Intent(getApplicationContext(), ResultActivity.class);

                //EditText bedrooms = (EditText) findViewById(R.id.bedrooms);
                //EditText bathrooms = (EditText) findViewById(R.id.bathrooms);

                //int bedrooms_i = Integer.parseInt(bedrooms.getText().toString());
                //int bathrooms_i = Integer.parseInt(bathrooms.getText().toString());
                //int result = 2000 * bedrooms_i + 1000 + 500 * (bathrooms_i - 1);
                outputIntent.putExtra("resultString",bed + bath + transit + amenities + hood + type);

                startActivity(outputIntent);

            }
        });
    }

    public void addListenerOnButton(){
        Spinner bed_s = (Spinner) findViewById(R.id.bed_s);
        bed_s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bed = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner bath_s = (Spinner) findViewById(R.id.bath_s);
        bed_s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bath = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner hood_s = (Spinner) findViewById(R.id.hood_s);
        bed_s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hood = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner type_s = (Spinner) findViewById(R.id.type_s);
        bed_s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner movein_s = (Spinner) findViewById(R.id.movein_s);
        bed_s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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


    }
}
