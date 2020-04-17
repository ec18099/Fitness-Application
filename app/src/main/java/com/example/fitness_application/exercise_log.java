package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;

public class exercise_log extends AppCompatActivity implements OnItemSelectedListener {
    Spinner spinner;
    private String exerciseName;
    private String calorieBurn;
    private int minutesVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log);
        final EditText minutes = findViewById(R.id.minutes);
        final Button confirm = findViewById(R.id.confirmation);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(exercise_log.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ExerciseNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);
        minutesVal = Integer.parseInt(minutes.getText().toString());


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTDEE();
            }
        });
    }

   public void changeTDEE(){

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        exerciseName = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
