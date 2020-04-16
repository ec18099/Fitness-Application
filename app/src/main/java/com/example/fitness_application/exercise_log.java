package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import android.database.sqlite.SQLiteDatabase;

public class exercise_log extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private SQLiteDatabaseHandler db;
    private SQLiteDatabase db2;
    Spinner spinner;
    int TDEE = 0;
    int caloriesBurned = 0;
    String exerciseName = "";
    //final Bundle extras = getIntent().getExtras();
    final Button confirm = findViewById(R.id.confirmation);

    final EditText minutes = findViewById(R.id.minutes);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log);
        spinner = findViewById(R.id.spinnerExercises);

        populateDatabase();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(exercise_log.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ExerciseNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercise_log.this, home_page.class);
                //intent.putExtra("key",Integer.toString((TDEE)));
                startActivity(intent);
            }
        });

    }

    public void populateDatabase(){
        ArrayList<String> name = new ArrayList<>();
        ExerciseList e1 = new ExerciseList();
        db = new SQLiteDatabaseHandler(this);
        e1.setId(1);
        e1.setName("Pushups             ");
        e1.setCaloriesBurnt("150 kcal                   ");
        e1.setDuration(10);

        ExerciseList e2 = new ExerciseList();
        e2.setId(2);
        e2.setName("Calf Raises         ");
        e2.setCaloriesBurnt("130 kcal                     ");
        e2.setDuration(7);

        ExerciseList e3 = new ExerciseList();
        e3.setId(3);
        e3.setName("Lunges                ");
        e3.setCaloriesBurnt("110 kcal                    ");
        e3.setDuration(9);

        ExerciseList e4 = new ExerciseList();
        e4.setId(4);
        e4.setName("Crunches             ");
        e4.setCaloriesBurnt("135 kcal                    ");
        e4.setDuration(8);

        ExerciseList e5 = new ExerciseList();
        e5.setId(5);
        e5.setName("Planks                 ");
        e5.setCaloriesBurnt("125 kcal                     ");
        e5.setDuration(5);

        ExerciseList e6 = new ExerciseList();
        e6.setId(6);
        e6.setName("Pullups                ");
        e6.setCaloriesBurnt("190 kcal                   ");
        e6.setDuration(10);

        ExerciseList e7 = new ExerciseList();
        e7.setId(7);
        e7.setName("Wallsits               ");
        e7.setCaloriesBurnt("145 kcal                   ");
        e7.setDuration(12);

        ExerciseList e8 = new ExerciseList();
        e8.setId(8);
        e8.setName("Squats                 ");
        e8.setCaloriesBurnt("80 kcal                      ");
        e8.setDuration(5);

        ExerciseList e9 = new ExerciseList();
        e9.setId(9);
        e9.setName("Burpees              ");
        e9.setCaloriesBurnt("100 kcal                     ");
        e9.setDuration(6);

        ExerciseList e10 = new ExerciseList();
        e10.setId(10);
        e10.setName("High Knees         ");
        e10.setCaloriesBurnt("150  kcal                  ");
        e10.setDuration(11);

        ExerciseList e11 = new ExerciseList();
        e11.setId(11);
        e11.setName("Tricep Dips          ");
        e11.setCaloriesBurnt("105 kcal                    ");
        e11.setDuration(4);

        ExerciseList e12 = new ExerciseList();
        e12.setId(12);
        e12.setName("Wallsit                  ");
        e12.setCaloriesBurnt("120 kcal                    ");
        e12.setDuration(5);

        ExerciseList e13 = new ExerciseList();
        e13.setId(13);
        e13.setName("Skaters                ");
        e13.setCaloriesBurnt("180 kcal                    ");
        e13.setDuration(18);

        ExerciseList e14 = new ExerciseList();
        e14.setId(14);
        e14.setName("Cardio                ");
        e14.setCaloriesBurnt("260 kcal                     ");
        e14.setDuration(20);


        db.addExercise(e1);
        db.addExercise(e2);
        db.addExercise(e3);
        db.addExercise(e4);
        db.addExercise(e5);
        db.addExercise(e6);
        db.addExercise(e7);
        db.addExercise(e8);
        db.addExercise(e9);
        db.addExercise(e10);
        db.addExercise(e11);
        db.addExercise(e12);
        db.addExercise(e13);
        db.addExercise(e14);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        exerciseName = parent.getItemAtPosition(position).toString() + "                ";
        db2 = db.getReadableDatabase();


        String q = "SELECT caloriesBurnt FROM Exercises WHERE name = '" + exerciseName + "'";
        Cursor c = db2.rawQuery(q, new String[]{ exerciseName });

        if(c.moveToFirst()){
            caloriesBurned = Integer.parseInt(c.getString(2));
        }

        /*if(extras != null){
            TDEE = Integer.parseInt(extras.getString("key"));
        }*/

        TDEE -= caloriesBurned;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
