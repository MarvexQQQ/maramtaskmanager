package com.example.maramtaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  implements DialogInterface.OnClickListener {
    private SearchView hs;
    private ListView HL;
    private FloatingActionButton prsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prsb = findViewById(R.id.prsb);
        hs = findViewById(R.id.hs);

        HL = findViewById(R.id.Hl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnItmSettings) {
        } else {
            Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.mnItmHistory) {
            Intent i = new Intent(getApplicationContext(), historyactivity.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.mnItmSignup) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //
            builder.setMessage("are u sure");
            //
            builder.setCancelable(false);

            builder.setPositiveButton("yes", this);
            //
            //builder.setNegativeButton("no", this);
            //
            AlertDialog dialog = builder.create();//
            //
            dialog.show();
            Intent i=new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(i);
        }
            return true;
        }


  // react handler
    // button witch the button id witch caused the event
    //dialoginterface the active dialog
    @Override
    public void onClick(DialogInterface dialogInterface, int wich) {
        if(wich==dialogInterface.BUTTON_POSITIVE)
        {
            Toast.makeText(getApplicationContext(), "loging out", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
            FirebaseAuth auth =FirebaseAuth.getInstance();
            auth.signOut();//signing out
            finish();

        }
        if(wich==dialogInterface.BUTTON_POSITIVE)
        {
            Toast.makeText(getApplicationContext(), "loging out canceled", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
        }
       //listener 4 react for each action
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture){

    }
}
