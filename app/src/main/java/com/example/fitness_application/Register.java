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
                checkValidity(fName,lName,email,password,password2,true);
            }
        });
    }

    // Checks if user is already logged in
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser,true);
    }

    // if current user is null, then user can access reg page, otherwise redirect.
    private void updateUI(FirebaseUser currentUser, boolean existingUser) {
        if(currentUser != null && !(existingUser)){
            startActivity(new Intent(Register.this, inputTDEE.class));
        }
        else if(currentUser != null && existingUser){
            startActivity(new Intent(Register.this, home_page.class));
        }
    }

    public void checkValidity(EditText fName, EditText lName, EditText email, EditText password, EditText password2,Boolean isValid){
        String fNameText = fName.getText().toString(); String lNameText = lName.getText().toString();
        String emailText = email.getText().toString(); String passwordText = password.getText().toString();
        String password2Text = password2.getText().toString();

        if(fNameText.length() < 1 || fNameText.length() > 15){
            fName.setError("Please input a valid first name");
            isValid = false;
        }

        if(lNameText.length() < 1 || lNameText.length() > 30){
            lName.setError("Please input a valid last name");
            isValid = false;
        }

        if(!(emailText.contains("@"))|| emailText.length() < 10 || emailText.length() > 40){
            email.setError("Please input a valid email");
            isValid = false;
        }

        if(passwordText.length() < 5 || passwordText.length() > 20){
            password.setError("Password must be between 5 to 20 characters long (inclusive)");
            isValid = false;
        }

        if(!(password2Text.equals(passwordText))){
            password2.setError("Passwords do not match");
            isValid = false;
        }
        if(isValid) {
            storeInDatabase(fNameText, lNameText, emailText, passwordText);
        }
        return;
    }
    public void showAlertDialogButtonClicked(String title, String message) {
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
                            showAlertDialogButtonClicked("Success","You have successfully registered! You will now be redirected.");
                            updateUI(user,false);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    //Toast.LENGTH_SHORT).show();
                            showAlertDialogButtonClicked("OOPS","Something went wrong with your registration. Please try again.");
                            updateUI(null,false);
                        }

                        // ...
                    }
                });
    }

}
