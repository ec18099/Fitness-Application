package com.example.fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button login = findViewById(R.id.blogin);
        final Button register = findViewById(R.id.bregister);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials(email,password);
            }
        });
    }

    public void validateCredentials(EditText email,EditText password){
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if(emailText.equals("")){
            email.setError("Please input your email");
            return;
        }
        if(passwordText.equals("")){
            password.setError("Please input your password");
            return;
        }

        if(!(emailText.contains("@")) || emailText.length() < 10  || emailText.length() > 40){
            email.setError("Please input a valid email");
            return;
        }

        if(passwordText.length() < 5 || passwordText.length() > 20){
            password.setError("Please input a valid password");
            return;
        }

    }

// Database code
    public boolean credentialsInDatabase(String emailText, String passwordText){

        return false;
    }
}
