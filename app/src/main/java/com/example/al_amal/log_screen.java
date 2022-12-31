package com.example.al_amal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class log_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_screen);
        Button log= findViewById(R.id.loog);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(log_screen.this,Login.class);
                startActivity(i);
                finish();
            }
        });
        Button siii= findViewById(R.id.siiignup);
        siii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(log_screen.this,Signup.class);
                startActivity(i);
                finish();
            }
        });
    }
}