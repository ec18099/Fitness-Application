package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class exercise_log extends AppCompatActivity implements OnItemSelectedListener {
    Spinner spinner;
    private String activityL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log);
        spinner = findViewById(R.id.activity);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(exercise_log.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ExerciseNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);

    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        activityL = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
