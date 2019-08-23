package com.example.finalissecure;


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

public class uploadImage extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        Button btnUpload = (Button) findViewById(R.id.etUploadImages);
        imageView = (ImageView) findViewById(R.id.imageViewBucky);


    }
    private  boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera2(View view){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(("s"),"before if");
        if(requestCode ==REQUEST_IMAGE_CAPTURE && resultCode ==RESULT_OK ) {

            Log.d(("s"),"after if");
            //super.onActivityResult(requestCode, resultCode, data);
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            //imageView.setImageBitmap(bitmap);
            imageView.setImageBitmap(bitmap);

        }
    }
}



