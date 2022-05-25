package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResturantList extends AppCompatActivity {
    private Button btn_brista;//define button_Brista
    private Button btn_mc;//define button_MC

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_list);
       btn_brista=(Button) findViewById(R.id.btn_brista);
        btn_brista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { booking_tableA(view);
            }
        });

       btn_mc=(Button) findViewById(R.id.btn_mc);
        btn_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booking_tableB();
            }
        });
    }
    //Brista book table function
    public void booking_tableA(View view) {
        Intent intent=new Intent(this, booking_tableA.class);
        startActivity(intent);
    }
    //MC book table function
    public void booking_tableB(){
        Intent intent=new Intent(this, booking_tableB.class);
        startActivity(intent);
    }

    }

