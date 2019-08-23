package com.example.finalissecure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {


    EditText ET_NAME,ET_USER,ET_PASS;
    EditText ET_NAME2,ET_USER2,ET_PASS2;
    String name,user_name,user_pass;
    String name2,user_name2,user_pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ET_NAME = (EditText) findViewById(R.id.etNamereg);
        ET_USER = (EditText) findViewById(R.id.etUsernamereg);
        ET_PASS = (EditText) findViewById(R.id.etPasswordreg);

        ET_NAME2 = (EditText) findViewById(R.id.etname);
        ET_USER2 = (EditText) findViewById(R.id.etUsername);
        ET_PASS2 = (EditText) findViewById(R.id.etPassword);
    }



    public void userReg(View view) {

        name = ET_NAME.getText().toString();
        user_name = ET_USER.getText().toString();
        user_pass = ET_PASS.getText().toString();
        String method = "register";

        if (name.isEmpty() || user_name.isEmpty() || user_pass.isEmpty()) {
            Toast.makeText(this, "please enter all the details", Toast.LENGTH_SHORT).show();

        }else {

            Log.d("t", "inside register");
            Background background = new Background(this);

            background.execute(method, name, user_name, user_pass);
            finish();
        }
    }
    public void loginto(View view){

        Log.d("i", "just clicked on userLogin");
        name2 = ET_NAME.getText().toString();
        user_name2 = ET_USER.getText().toString();
        user_pass2 = ET_PASS.getText().toString();
        String method = "login";

        Background background = new Background(this);
        background.execute(method,name2,user_name2,user_pass2);

    }
    public void backlogin(View view){
        startActivity(new Intent(this,register.class));
    }
}
