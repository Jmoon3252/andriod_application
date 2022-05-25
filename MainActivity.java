package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_logo=(Button) findViewById(R.id.btn_logo);
        btn_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWelcome();
            }
        });
    }
    public void openWelcome(){
        Intent intent10=new Intent(this, welcome_page.class);
        startActivity(intent10);
    }
}