package com.example.finalissecure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void userLogin(View view){
        startActivity(new Intent(this,login.class));
    }
    public void userReg(View view){
        startActivity(new Intent(this,registration.class));


    }
    public void loginto(View view){

    }

}
