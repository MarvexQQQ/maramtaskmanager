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

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText t1,t2,t3,t4,t5;
    private Button bt1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        bt1=findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });



    }

    private void validate() {
        String email = t1.getText().toString();

        boolean isok=true;
        String fname = t1.getText().toString();
        String lastname = t2.getText().toString();
        String email2 = t3.getText().toString();
        String password = t4.getText().toString();
        String PASS2=t4.getText().toString();
        String number = t5.getText().toString();

        if (email2.length()<5||email2.indexOf('@')<=0)
        {
            t3.setError("wrong email ");
            isok=false;
        }
        if (fname.length()<2)
        {
           t1.setError("must enter full name");
           isok=false;
        }
        if (password.equals(PASS2)==false)
        {
            t4.setError("not equals passwords");
            isok=false;
        }
        if(fname.length()==0)
        {
            t1.setError("must ");
            isok=false;

        }
        if (number.length()!=10)
        {
            t5.setError("your number needs to be 10 digets ");
            isok=false;

        }
        if (lastname.length()==0)
        {
            t2.setError("must enter full last name");
            isok=false;
        }
        if (number.startsWith("05")==false)
        {
            t5.setError("your number needs to start with 05");
            isok=false;
        }
        if (isok)
        {
            createAccount(email2,password);

        }
    }

    private void createAccount(String email2, String password) {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email2,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() == true) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else{
                    //dialog
                    Toast.makeText(getApplicationContext(), "error creat account" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}