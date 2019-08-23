
package com.example.finalissecure;


        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;

public class commentImage extends AsyncTask<String,Void,String> {

    Context ctx;
    boolean pass = false;
    AlertDialog dialog;
    EditText okay;

    commentImage(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {

        dialog = new AlertDialog.Builder(ctx).create();
        dialog.setTitle("Login Status");


    }
    protected String doInBackground(String... params) {

        String st ="";

        String reg_url = "http://192.168.0.10/loginapp/register.php";

        String text_url = "http://192.168.0.10/loginapp/text.php";
        String name = params[0];
        String accepted = params[1];
        String comment = params[2];
        System.out.println("inside commentImage: " + accepted + " " + comment);
        try {
            URL url = new URL(text_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("name","UTF-8") +"="+URLEncoder.encode(name,"UTF-8")+"&"
                    +URLEncoder.encode("accepted","UTF-8") +"="+URLEncoder.encode(accepted,"UTF-8")+"&"+
                    URLEncoder.encode("comment","UTF-8") +"="+URLEncoder.encode(comment,"UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            System.out.println(" still in commentImage");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        st = "posting text success";
        return st;
    }



}
