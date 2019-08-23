package com.example.finalissecure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static boolean checking = false;
    public static boolean checking2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

 //  public void userReg(View view){
    //    startActivity(new Intent(this,registration.class));
   // }
    public void gotoReg(View view){

        startActivity(new Intent(this,register.class));
        checking = true;
    }
    public void gotoReg2(View view){
        checking2 = true;
        startActivity(new Intent(this,register.class));
    }

    /*public void loginto(View view){

    }*/
    /*public void backlogin(View view){


    }*/

}
