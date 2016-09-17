package com.kyo.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.kyo.lostshopping.LogInActivity;
import com.kyo.model.CUSTOMER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ASUS on 9/10/2016.
 */
public class CreateAccountTask extends AsyncTask<CUSTOMER,Void,Boolean> {

    Activity context;
    public CreateAccountTask(Activity context)
    {
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean b) {
        super.onPostExecute(b);
        String msg="Create failed";
        if(b)
        {
            msg="Create success";
            Intent intent=new Intent(this.context,LogInActivity.class);
            this.context.startActivity(intent);
        }

        Toast.makeText(this.context,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(CUSTOMER... params) {
        try
        {
            CUSTOMER customer=params[0];
            String parameter="?acc="+customer.getCUS_ACCOUNT()+"&pass="+customer.getCUS_PASS()+"&first_name="+customer.getCUS_FIRSTNAME()
                    +"&last_name="+customer.getCUS_LASTNAME()+"&email="+customer.getCUS_EMAIL();
            URL url=new URL("http://192.168.56.1/lostshopping/api/customer"+parameter);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json; charset=utf-8");
            InputStreamReader isr=new InputStreamReader(connection.getInputStream(),"UTF-8");
            BufferedReader br=new BufferedReader(isr);
            StringBuilder builder=new StringBuilder();
            String line=br.readLine();
            while (line!=null)
            {
                builder.append(line);
                line=br.readLine();
            }
            String result=builder.toString();
            return result.contains("true");
        }
        catch (Exception ex)
        {
            Log.e("Create Account_LOG",ex.toString());
        }

        return false;
    }
}
