package com.example.fitness_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class home_page extends AppCompatActivity {
    DatabaseReference nRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference TDEEref = nRootRef.child("TDEE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        final CardView suggested_dietPlan = findViewById(R.id.dietPlans);
        final CardView consumption_log = findViewById(R.id.consumption);
        final CardView exerciseLog = findViewById(R.id.exercise_log);
        final CardView input_weight = findViewById(R.id.weight_change);
        final CardView suggested_meals = findViewById(R.id.suggested_meals);
        final CardView suggested_exercises = findViewById(R.id.suggested_exercises);
        final Button logout = findViewById(R.id.logout);
        TextView myTDEE = findViewById(R.id.TDEE);
        String TDEE = "";
        myTDEE.setText("MY TDEE:" + TDEE);




        //myTDEE.setText("MY TDEE: " + TDEE);
        //final Bundle extras = getIntent().getExtras();
        /*if(extras != null){
            TDEE = extras.getString("key");
            myTDEE.setText("MY TDEE:" + TDEE);
        }
        // add TDEE value below.
        if(myTDEE.getText().toString().equals("MY TDEE:")){
            startActivity(new Intent(home_page.this, inputTDEE.class));
        }
        */

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

        suggested_meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home_page.this, viewMealList.class));
            }
        });

        exerciseLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, exercise_log.class);
                intent.putExtra("key", getIntent().getExtras());
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                //extras.clear();
                startActivity(new Intent(home_page.this, Register.class));
            }
        });

    }

}
