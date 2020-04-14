package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final CardView suggested_dietPlan = findViewById(R.id.dietPlans);
        final CardView consumption_log;
        final CardView exercise_log;
        final CardView input_weight;
        final CardView suggested_meals;
        final CardView suggested_exercises;

        // tesing button, replace with actual page.
        suggested_dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_page.this, Register.class));
            }
        });
    }
}
