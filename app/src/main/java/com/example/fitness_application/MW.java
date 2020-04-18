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

public class MW extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintain_weight);

        Button btnToBack = (Button) findViewById(R.id.button);
        btnToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnToBack");

                Intent intent = new Intent(MW.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ListView list = (ListView) findViewById(R.id.list2);
        ArrayList<String> plans = new ArrayList<>();
        plans.add("Eat at least 5 portions of a variety of fruit and vegetables every day.");
        plans.add("Base meals on higher fibre starchy foods like potatoes, bread, rice or pasta.");
        plans.add("Have some dairy or dairy alternatives (such as soya drinks).");
        plans.add("Eat some beans, pulses, fish, eggs, meat and other protein.");
        plans.add("Choose unsaturated oils and spreads, and eat them in small amounts.");
        plans.add("Drink plenty of fluids (at least 6 to 8 glasses a day).");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, plans);
        list.setAdapter(adapter);
    }
}
