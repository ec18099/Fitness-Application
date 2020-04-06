package com.example.fitness_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Button clear = findViewById(R.id.clear);
        final Button submit = findViewById(R.id.submit);
        final EditText fName = findViewById((R.id.fname));
        final EditText lName = findViewById(R.id.lname);
        final EditText email = findViewById(R.id.emailreg);
        final EditText password = findViewById(R.id.passwordreg);
        final EditText password2 = findViewById(R.id.passwordreg2);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName.setText("");
                lName.setText("");
                email.setText("");
                password.setText("");
                password2.setText("");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidity(fName,lName,email,password,password2);
            }
        });
    }

    // Checks if user is already logged in
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    // if current uesr is null, then user can access reg page, otherwise redirect.
    private void updateUI(FirebaseUser currentUser) {

    }

    public void checkValidity(EditText fName, EditText lName, EditText email, EditText password, EditText password2){
        String fNameText = fName.getText().toString(); String lNameText = lName.getText().toString();
        String emailText = email.getText().toString(); String passwordText = password.getText().toString();
        String password2Text = password2.getText().toString();

        if(fNameText.length() < 1 || fNameText.length() > 15){
            fName.setError("Please input a valid first name");
            return;
        }

        if(lNameText.length() < 1 || lNameText.length() > 30){
            lName.setError("Please input a valid last name");
            return;
        }

        if(!(emailText.contains("@"))|| emailText.length() < 10 || emailText.length() > 40){
            email.setError("Please input a valid email");
            return;
        }

        if(passwordText.length() < 5 || passwordText.length() > 20){
            password.setError("Password must be between 5 to 20 characters long (inclusive)");
            return;
        }

        if(!(password2Text.equals(passwordText))){
            password2.setError("Passwords do not match");
            return;
        }

        storeInDatabase(fNameText, lNameText, emailText, passwordText);

    }

    // Database code TEST
    public void storeInDatabase(String fname, String lname, String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    private static final String TAG ="Fitness_Application" ;

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
