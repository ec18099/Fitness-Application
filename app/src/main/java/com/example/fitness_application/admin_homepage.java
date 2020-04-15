package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);
        final CardView edit_exercises = findViewById(R.id.editExercises);
        final CardView edit_meals = findViewById(R.id.editMeals);
        final Button logout = findViewById(R.id.admin_logout);

        edit_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_homepage.this, viewExerciseList.class));
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_homepage.this, MainActivity.class));
            }
        });



    }
}
