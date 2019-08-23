package com.example.finalissecure;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class getFeedback extends AppCompatActivity {

    String st;
    TextView tv;
    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;


    Button  feedbackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_feedback);

        feedbackBtn = (Button)findViewById(R.id.feedbackBtn);
        tv = (TextView) findViewById(R.id.feedbackText);
        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("feedback button clicked !!");
                getFeedbackButton();

            }
        });
    }
    public void getFeedbackButton(){
        class AsyncTaskUploadClass2 extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

            }

            @Override
            protected String doInBackground(Void... params) {
                System.out.println("inside doInBackground ");
                String st = "http://192.168.0.10/loginapp/retrieve.php";
                System.out.println(st);
                String stringUrl = st;
                String result;
                String inputLine;
                try {
                    //Create a URL object holding our url
                    URL myUrl = new URL(stringUrl);
                    //Create a connection
                    HttpURLConnection connection =(HttpURLConnection)
                            myUrl.openConnection();
                    //Set methods and timeouts
                    connection.setRequestMethod(REQUEST_METHOD);
                    
                    //Connect to our url
                    connection.connect();
                    //Create a new InputStreamReader
                    InputStreamReader streamReader = new
                            InputStreamReader(connection.getInputStream());
                    //Create a new buffered reader and String Builder
                    BufferedReader reader = new BufferedReader(streamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    //Check if the line we are reading is not null
                    while((inputLine = reader.readLine()) != null){
                        stringBuilder.append(inputLine);
                    }
                    //Close our InputStream and Buffered reader
                    reader.close();
                    streamReader.close();
                    //Set our result equal to our stringBuilder
                    result = stringBuilder.toString();
                    System.out.println("result is " + result);
                }
                catch(IOException e){
                    e.printStackTrace();
                    result = null;
                }
                tv.append(result);
                return result;


            }
        }
        AsyncTaskUploadClass2 AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass2();

        AsyncTaskUploadClassOBJ.execute();


    }

}
