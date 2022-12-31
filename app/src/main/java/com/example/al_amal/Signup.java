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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    EditText id,pass,email,name;
    TextView log;
    Button new_log;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        id = findViewById(R.id.id);
        pass = findViewById(R.id.pass);
        name = findViewById(R.id.fullname);
        email = findViewById(R.id.phonn);
       // log=findViewById(R.id.loog);
        new_log = findViewById(R.id.newlog);
        firebaseAuth= FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("users");
        new_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            firebaseUser=task.getResult().getUser();
                            DatabaseReference newUser=databaseReference.child(firebaseUser.getUid());
                            newUser.child("email").setValue(email.getText().toString());
                            newUser.child("password").setValue(pass.getText().toString());
                            newUser.child("id").setValue(id.getText().toString());
                            newUser.child("name").setValue(name.getText().toString());


                            Toast.makeText(Signup.this,"done",Toast.LENGTH_LONG).show();
                            Intent toSigin = new Intent(Signup.this,Login.class);
                            startActivity(toSigin);
                            finish();
                        }else{
                            Toast.makeText(Signup.this,"Error",Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });

    }
}