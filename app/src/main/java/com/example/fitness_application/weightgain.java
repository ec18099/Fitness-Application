package com.example.fitness_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

private static final String TAG="weightgain";

public class weightgain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weightggain);
        Log.d(TAG, "onCreate: Starting");

        Button btnToBack = (Button) findViewById(R.id.button);
        btnToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnToBack");

                Intent intent = new Intent(weightgain.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ListView list = (ListView) findViewById(R.id.thelist);
        ArrayList<String> plans = new ArrayList<>();
        plans.add("Consume more milk.");
        plans.add("Consume more rice.");
        plans.add("Consume more red meat.");
        plans.add("Consume more nuts and nut butters.");
        plans.add("Consume more potatoes and starch.");
        plans.add("Consume more salmon and oily fish.");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, plans);
        list.setAdapter(adapter);
    }
}
