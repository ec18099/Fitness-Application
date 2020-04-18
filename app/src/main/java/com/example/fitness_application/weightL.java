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

public class weightL extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_loss);

        Button btnToBack = (Button) findViewById(R.id.button);
        btnToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked btnToBack");

                Intent intent = new Intent(weightL.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ListView list = (ListView) findViewById(R.id.list1);
        ArrayList<String> plans = new ArrayList<>();
        plans.add("Consume more broccoli.");
        plans.add("Consume more kale.");
        plans.add("Consume more healthy fats like butter.");
        plans.add("Consume less protein.");
        plans.add("Exercise more regularly and drink only protein shakes.");
        plans.add("Consume less carbohydrates.");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, plans);
        list.setAdapter(adapter);
    }
}
