package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


public class inputTDEE extends AppCompatActivity {


    private EditText heightInput;
    private EditText weightInput;
    private EditText ageInput;
    private EditText sexInput;
    private EditText activityLevelsInput;

    Button calcTDEE;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_t_d_e_e);
        TextView theTextView = (TextView) findViewById(R.id.text01);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ActivityLevels,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);

        theTextView.setText("Calculate TDEE");
        heightInput = (EditText) findViewById(R.id.heightInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
        ageInput = (EditText) findViewById(R.id.ageInput);
        sexInput = (EditText) findViewById(R.id.sexInput);
        activityLevelsInput = (EditText) findViewById(R.id.activityLevelsInput);

        calcTDEE = (Button) findViewById(R.id.calcTDEE);
        calcTDEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculateTDEE p1 = new calculateTDEE();
                    p1.setHeight(Double.parseDouble(heightInput.getText().toString()));
                    p1.setWeight(Double.parseDouble(weightInput.getText().toString()));
                    p1.setAge(Integer.parseInt(ageInput.getText().toString()));
                    p1.setSex(sexInput.getText().toString());
                    p1.setActivityLevels(activityLevelsInput.getText().toString());




                    p1.setTDEE(p1.getHeight(),p1.getWeight(),p1.getAge(),p1.getSex(),p1.getActivityLevels());

                    showToast(String.valueOf(p1.getTDEE()));
                    Intent intent = new Intent(inputTDEE.this, home_page.class);
                    intent.putExtra("key",p1.getTDEE());
                    startActivity(intent);

                }catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }


            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
*/
    private void showToast(String text){
        Toast.makeText(inputTDEE.this, text, Toast.LENGTH_SHORT).show();

    }
}
