package com.example.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_page extends AppCompatActivity {
    private FirebaseAuth login_Auth;
   // private Button btn_clear;
    private EditText ed_email,ed_pass;
    private Button btn_signup;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
     //Define all variables for SignUp form
        login_Auth = FirebaseAuth.getInstance();
        ed_email=(EditText) findViewById(R.id.ed_email);
        ed_pass=(EditText) findViewById(R.id.ed_pass);
        btn_signup=(Button) findViewById(R.id.btn_signup);
   //    btn_clear=(Button) findViewById(R.id.btn_clear);
        progressDialog = new ProgressDialog(SignUp_page.this);
        progressDialog.setTitle("Please wait a seconds");
        progressDialog.setMessage("Congratulations! You are registering");

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String useremail = ed_email.getText().toString().trim();
                final String userpass = ed_pass.getText().toString().trim();
                try {
                    userRegistering(useremail,userpass);
                }catch (Exception e){

                    Toast.makeText(SignUp_page.this, "exception is "+e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

      /*  btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });*/
    }
  /*  public void clear(){
        ed_name.setText("");
    }*/
    private void userRegistering(String useremail, String userpass){
        progressDialog.show();
        login_Auth.createUserWithEmailAndPassword(useremail,userpass). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUp_page.this, "Congratulations! Your logging  is successful", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    Intent login_intent= new Intent(SignUp_page.this,LogIn.class );
                    startActivity(login_intent);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp_page.this, "The errorr is:"+e.toString(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}