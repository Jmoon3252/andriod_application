package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
private Button btn_signin;
    private Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_signin=(Button) findViewById(R.id.btn_signin);
        btn_signup=(Button) findViewById(R.id.btn_signup);
//register new user=signup button
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignInpage();
            }
        });
        //login user
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogIn();
            }
        });
    }
    //signup finction
    public void openSignInpage(){
        Intent intent1=new Intent(this, SignUp_page.class);
        startActivity(intent1);
    }
  //signin function
    public void openLogIn(){
        Intent intent2=new Intent(this, LogIn.class);
        startActivity(intent2);
    }

}