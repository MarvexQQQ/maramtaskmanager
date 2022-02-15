package com.example.maramtaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Mydata.MyTask;

public class addtaskactivity extends AppCompatActivity {
    private TextInputEditText tl,sub;
    private Button btn;
    private ImageView img;
    private Button btn0;
    private Spinner nec;
    private SeekBar imp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtaskactivity);
        tl = findViewById(R.id.tl);
        sub = findViewById(R.id.sub);
        btn0 = findViewById(R.id.btn0);
        nec = findViewById(R.id.nec);
        imp = findViewById(R.id.sb);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

            }
        });
    }



           private void validate(){
               String title =tl.getText().toString();
               String subject=sub.getText().toString();
               int progress= imp.getProgress();
               String importnace=nec.getSelectedItem().toString();
               boolean isok=true;
               if (title.length()==8)
               {
                   tl.setError("must enter subject");
                   isok=false;

               }
               if (isok)
               {
                   MyTask myTask=new MyTask();
                   myTask.setTitle(title);
                   myTask.setSubject(subject);

                   String vid= FirebaseAuth.getInstance().getCurrentUser().getUid();
                   myTask.setOwner(vid);
                   FirebaseDatabase db=FirebaseDatabase.getInstance();
                   DatabaseReference ref=db.getReference();
                   String key=ref.child("my tasks").push().getKey();
                   myTask.setKey(key);
                   ref.child("my task").child(key).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if (task.isSuccessful())
                           {
                               Toast.makeText(getApplicationContext(),"add successful",Toast.LENGTH_SHORT).show();
                               finish();
                           }
                           else
                           {
                               Toast.makeText(getApplicationContext(),"add error",Toast.LENGTH_SHORT).show();

                           }
                       }
                   });

           }

       }



}

//addtask and mytask activites are messed up together
//every thing that gets saved has its own key(id)
