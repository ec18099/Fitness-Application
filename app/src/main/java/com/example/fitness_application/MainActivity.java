package com.example.fitness_application;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Boolean isValid = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button login = findViewById(R.id.blogin);
        final Button register = findViewById(R.id.bregister);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

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

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if(currentUser == null && !(isValid)){
            //inform them.
            showAlertDialogButtonClicked();
        }
        else if(currentUser != null && (isValid)){
            startActivity(new Intent(MainActivity.this, home_page.class));
        }
    }

    public void showAlertDialogButtonClicked() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login Failed");
        builder.setMessage("Either your email, password, or both are incorrect.");

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void validateCredentials(EditText email,EditText password){
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if(emailText.equals("admin")){
            adminCheck(passwordText);
        }

        if(emailText.equals("")){
            email.setError("Please input your email");
            isValid = false;
        }
        if(passwordText.equals("")){
            password.setError("Please input your password");
            isValid = false;
        }

        if(!(emailText.contains("@")) || emailText.length() < 10  || emailText.length() > 40){
            email.setError("Please input a valid email");
            isValid = false;
        }

        if(passwordText.length() < 5 || passwordText.length() > 20){
            password.setError("Please input a valid password");
            isValid = false;
        }

        if(isValid){
            //check credentials against database.
            credentialsInDatabase(emailText,passwordText);
        }

        return;

    }

    //admin check
    public void adminCheck(String password){
        if(password.equals("admin123")){
            startActivity(new Intent(MainActivity.this, admin_homepage.class));
        }
        else{
            updateUI(null);
        }
    }
// Database code
    public void credentialsInDatabase(String emailText, String passwordText){
        mAuth.signInWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    private static final String TAG = "";

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });

    }

    //Diet plan Code
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        Button btnToWG = (Button) findViewById(R.id.button1);
        btnToWG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked btnToWG");

                Intent intent= new Intent(MainActivity.this, weightgain.class);
                startActivity(intent);
            }
        });
        Button btnToWL = (Button) findViewById(R.id.button2);
        btnToWL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked btnToWL");

                Intent intent= new Intent(MainActivity.this, weightL.class);
                startActivity(intent);
            }
        });
        Button btnToMW = (Button) findViewById(R.id.button3);
        btnToMW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked btnToMW");

                Intent intent= new Intent(MainActivity.this, MW.class);
                startActivity(intent);
            }
        });

    }
}
