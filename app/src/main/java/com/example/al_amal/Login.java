package com.example.al_amal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText phon,pass;
    TextView forgetpass,new_reg;
    Button login;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView reg = findViewById(R.id.nwlog);
        phon = findViewById(R.id.phon);
        pass = findViewById(R.id.passS);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });
        Button log = findViewById(R.id.log);

        firebaseAuth= FirebaseAuth.getInstance();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signInWithEmailAndPassword(phon.getText().toString(), pass.getText().
                        toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // PreferenceUtils.saveid("spass", register.this);

                                    Intent i = new Intent(Login.this,MainActivity.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(Login.this, "Welcome", Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(Login.this, "Error please check your email or password", Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });
    }
}