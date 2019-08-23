package com.example.finalissecure;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
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

public class Background extends AsyncTask<String,Void,String> {

    Context ctx;
    boolean pass = false;
    AlertDialog dialog;

    Background(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {

        dialog = new AlertDialog.Builder(ctx).create();
        dialog.setTitle("Login Status");

        /*if(pass) {

            ctx.startActivity(new Intent(ctx, upload.class));
        }*/

        //super.onPreExecute();
    }
   // @Override
  //  protected void onPostExecute(String a) {
       /*         Log.d("e","in on post execute" + a);
            if (a.equals("Connection success...login successfull")) {
                myclass mc = new myclass();
                mc.direct();

            }*/

        // Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    //    dialog.setMessage(a);
    //    dialog.show();
    //}


    @Override
    protected String doInBackground(String... params) {

        //String reg_url = "http://10.0.2.2/loginapp/register.php";
        //String reg_url = "http://127.0.0.1/loginapp/register.php";
        String reg_url = "http://192.168.0.10/loginapp/register.php";
        //String reg_url = "http://192.168.0.255/loginapp/register.php";
        //String reg_url = "http:/localhost/loginapp/register.php";


        //String login_url = "http:/localhost/loginapp/login.php";
         //String login_url = "http://10.0.2.2/loginapp/login.php";
        //String login_url = "http://127.0.0.1/loginapp/login.php";
        String login_url = "http://192.168.0.10/loginapp/login.php";
        //String login_url = "http://192.168.0.255/loginapp/login.php";


         String result = "";

        String method = params[0];
        if(method.equals("register")){
            Log.d("e","inside method is equal");
            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];

            try {

                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("name","UTF-8") +"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("user_name","UTF-8") +"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("user_pass","UTF-8") +"="+URLEncoder.encode(user_pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                result = "registration success";
                //return result;

            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {//if(method.equals("login")){

            Log.d("c","inside login !!");
            String name2 = params[1];
            String username2 = params[2];
            String password2 = params[3];
            //String result = "";

            try {
                URL url = new URL(login_url);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                OutputStream ops = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("name","UTF-8") +"=" + URLEncoder.encode(name2,"UTF-8")
                        + "&&" +
                        URLEncoder.encode("user_name","UTF-8") +"=" + URLEncoder.encode(username2,"UTF-8")
                        + "&&" + URLEncoder.encode("user_password","UTF-8") +"=" + URLEncoder.encode(password2,"UTF-8");

                writer.write(data);
                writer.flush();
                writer.close();
                ops.close();

                InputStream ips = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
                String line ="";
                while((line = reader.readLine()) != null){
                    result += line;
                    Log.d("h","result is " +result);

                }
                reader.close();
                ips.close();
                http.disconnect();
                Log.d("t","result is " + result);
                return result;


            }catch (MalformedURLException e){
                result = e.getMessage();
            }
            catch (IOException e){
                result = e.getMessage();
            }
            Log.d("t","value of result in login is " +result);
            //return result;


        }
        return result;
    }

   /* @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
*/
    @Override
    protected void onPostExecute(String result) {

        MainActivity m = new MainActivity();
        Log.d("i","checking boolean is " + m.checking);

        if(result.equals("Connection success...login successfull") && m.checking2==true){
            Log.d("ss","i am going to download class");
            ctx.startActivity(new Intent(ctx, Download.class));
        }
        if(result.equals("Connection success...login successfull") && m.checking==true){
            //pass = true;
            Log.d("s"," i am going to upload class");
            // ctx.startActivity(new Intent(ctx, upload.class));
            ctx.startActivity(new Intent(ctx,upload.class));
        }
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
       // dialog.setMessage(result);
//        dialog.show();
    }
}
