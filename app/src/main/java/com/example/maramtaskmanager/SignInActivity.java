package com.example.maramtaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private TextInputEditText etemail,etpassword;
    private Button btnsignin,btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);
        btnsignin=findViewById(R.id.btnsignin);
        btnregister=findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });


    }
    private void validate()
    {
        boolean isok=true;
        String email=etemail.getText().toString();
        String password=etpassword.getText().toString();
        if (email.length()==0)
        {
            etemail.setError("enter email");
            isok=false;
        }
        if (password.length()<8)
        {
            etpassword.setError("password at least 8 chars");
            isok=false;
        }
        if (isok)
            signingIn(email, password);
    }

    private void signingIn(String email, String password)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "sign in successful", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
                else
                    Toast.makeText(getApplicationContext(), "signing in is Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}