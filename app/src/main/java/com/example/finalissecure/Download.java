package com.example.finalissecure;

import android.app.AlertDialog;
import android.util.Pair;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ImageView;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.BufferedReader;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.UnsupportedEncodingException;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import java.io.BufferedInputStream;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class Download extends AppCompatActivity  {

    ImageView imageView;
    EditText nameOfImage;
    EditText okay;
    EditText comment;
    String str2,str3,name;
    Button  DownloadImage;
    Button Rotate;
    String str;

    String path = "http:192.168.0.10/loginapp/uploadImages/";


    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        DownloadImage = (Button)findViewById(R.id.bsec);
        nameOfImage = (EditText) findViewById(R.id.Imagename);
        okay = (EditText) findViewById(R.id.ok);
        comment = (EditText) findViewById(R.id.comment);
        Rotate  = (Button) findViewById(R.id.rotate);

        Rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateImage(path,str);
            }
        });

        DownloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = nameOfImage.getText().toString();
                str2 = okay.getText().toString();
                str3 = comment.getText().toString();
                name = nameOfImage.getText().toString();
                System.out.println("before calling postSms");
                DownloadImageFromPath(path,str);
                System.out.println("okay " + str2 + " comment "+ str3);
                if(!str2.isEmpty() && !str3.isEmpty()) {
                    postSms(name, str2, str3);
                }

            }
        });


    }

    public void DownloadImageFromPath(String path, String str){

        String result = path + str;
        imageView = (ImageView) findViewById(R.id.imageViewDownload);


        Picasso.with(this).load(path+str).networkPolicy(NetworkPolicy.NO_CACHE).into(imageView);



    }
    public void RotateImage(String path, String str){
        String result = path + str;
        Picasso.with(this).load(path+str).rotate(90f).networkPolicy(NetworkPolicy.NO_CACHE).into(imageView);
    }



    public void postSms(String name,String okay,String comment) {

        System.out.println("passed into postSms " + "okay is " + okay + "comment is " + comment);
        commentImage commentImage = new commentImage(this);
        commentImage.execute(name,okay,comment);

    }


}
