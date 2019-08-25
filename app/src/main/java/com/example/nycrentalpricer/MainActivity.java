package com.example.nycrentalpricer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
        Spinner s = (Spinner) findViewById(R.id.moveInNum);
        s.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                moveIn = Integer.parseInt(parent.getSelectedItem().toString());
            }
        });
 */
        Button enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outputIntent = new Intent(getApplicationContext(), ResultActivity.class);

                EditText bedrooms = (EditText) findViewById(R.id.bedrooms);
                EditText bathrooms = (EditText) findViewById(R.id.bathrooms);

                int bedrooms_i = Integer.parseInt(bedrooms.getText().toString());
                int bathrooms_i = Integer.parseInt(bathrooms.getText().toString());
                int result = 2000 * bedrooms_i + 1000 + 500 * (bathrooms_i - 1);
                outputIntent.putExtra("resultPrice","$" + result);

                startActivity(outputIntent);

            }
        });


    }
}
