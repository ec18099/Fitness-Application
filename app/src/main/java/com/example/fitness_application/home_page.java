package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final CardView suggested_dietPlan = findViewById(R.id.dietPlans);
        final CardView consumption_log = findViewById(R.id.consumption);
        final CardView exercise_log = findViewById(R.id.exercise_log);
        final CardView input_weight = findViewById(R.id.weight_change);
        final CardView suggested_meals = findViewById(R.id.suggested_meals);
        final CardView suggested_exercises = findViewById(R.id.suggested_exercises);
        final Button logout = findViewById(R.id.logout);
        TextView myTDEE = findViewById(R.id.TDEE);
        String TDEE = "";
        final Bundle extras = getIntent().getExtras();
        if(extras != null){
            TDEE = extras.getString("key");
        }
        // add TDEE value below.
        myTDEE.setText("MY TDEE:" + TDEE);

        // testing button, replace with actual page.
        suggested_dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_page.this, Register.class));
            }
        });

        suggested_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_page.this, viewExerciseList.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                extras.clear();
                startActivity(new Intent(home_page.this, Register.class));
            }
        });

    }

}
