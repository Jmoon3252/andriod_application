package com.example.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogIn extends AppCompatActivity {
   private EditText userEmail, userPass;//define edit text fields
   private FirebaseAuth login_Auth;//define login_auth variable for firebase
   private Button btn_signin;//define sign in btm
 //  private TextView user_attempts;//define user attempts variable
 //  private int attempts_count=3;//set the number of user login attempts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        login_Auth = FirebaseAuth.getInstance();
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPass = (EditText) findViewById(R.id.userPass);
   //     user_attempts = (TextView) findViewById(R.id.user_attempts);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = userEmail.getText().toString().trim();
                String password = userPass.getText().toString().trim();
                userLogin(email, password);
            }
        });
        //limit user login attempts section
    /*    attempts_count--;//to decrease the number of login attempts
        user_attempts.setText("Sorry, you have "+String.valueOf(attempts_count)+" remaining attempts Only");//to print it
        if(attempts_count==0){// if-statement to implement this condition after 3 login attempts
            btn_signin.setEnabled(false);//to display sign in btm after 3 user login attempts
        }*/
    }

// firebase section
    private void userLogin(String email, String password){
       login_Auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()) {
                   Toast.makeText(LogIn.this, "Great! Your Login Successfully", Toast.LENGTH_SHORT).show();

                   Intent login_success = new Intent(LogIn.this, ResturantList.class);
                   login_success.putExtra("email", login_Auth.getCurrentUser().getEmail());
                   startActivity(login_success);
               } else {
                   Toast.makeText(LogIn.this, "Opps! The error is: " + task.getException(), Toast.LENGTH_SHORT).show();
               }
           }
       });
        }
    }



