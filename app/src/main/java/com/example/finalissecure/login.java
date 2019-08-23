package com.example.finalissecure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText ET_NAME2,ET_USER2,ET_PASS2;
    String name2,user_name2,user_pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ET_NAME2 = (EditText) findViewById(R.id.etname);
        ET_USER2 = (EditText) findViewById(R.id.etUsername);
        ET_PASS2 = (EditText) findViewById(R.id.etPassword);
    }

    public void loginto(View view){

        Log.d("i", "just clicked on userLogin");
        name2 = ET_NAME2.getText().toString();
        user_name2 = ET_USER2.getText().toString();
        user_pass2 = ET_PASS2.getText().toString();
        String method = "login";
        //System.out.println("inside login :username" + user_name2);
        Background background = new Background(this);
        background.execute(method,name2,user_name2,user_pass2);

    }
}
