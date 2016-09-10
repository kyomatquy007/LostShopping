package com.kyo.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.kyo.lostshopping.MainActivity;
import com.kyo.model.CUSTOMER;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS on 9/7/2016.
 */
public class SignInTask extends AsyncTask<String, Void,CUSTOMER>{

    Activity context;
    public SignInTask(Activity context)
    {
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(CUSTOMER customer) {
        super.onPostExecute(customer);
        String msg="Login failed";
        if(customer!=null)
        {
            msg="Login success";
            Intent intent=new Intent(this.context, MainActivity.class);
            this.context.startActivity(intent);
        }
        Toast.makeText(this.context,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected CUSTOMER doInBackground(String... params) {
        try
        {
            String account=params[0];
            String password=params[1];
            //URL("http://192.168.56.1/lostshopping/api/customer?account="+account+"&password="+password):
            //192.168.56.1: Mobile IP Address
            //lostshopping: Application pool
            //api/customer : Controller
            URL url=new URL("http://192.168.56.1/lostshopping/api/customer?account="+account+"&password="+password); //not done yet
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //application/json: Json Format
            connection.setRequestProperty("Content-Type","application/json; charset=utf-8");
            InputStreamReader isr=new InputStreamReader(connection.getInputStream(),"UTF-8");
            BufferedReader br=new BufferedReader(isr);
            StringBuilder builder=new StringBuilder();
            String line=br.readLine();
            while(line!=null)
            {
                builder.append(line);
                line=br.readLine();
            }
            String json=builder.toString();
            JSONObject jsonObject=new JSONObject(json);
            CUSTOMER customer=new CUSTOMER();
            customer.setCUS_ACCOUNT(jsonObject.getString("CUS_ACCOUNT"));
            customer.setCUS_ADDRESS(jsonObject.getString("CUS_ADDRESS"));
            customer.setCUS_CITY(jsonObject.getString("CUS_CITY"));
            customer.setCUS_COUNTRY(jsonObject.getString("CUS_COUNTRY"));
            customer.setCUS_EMAIL(jsonObject.getString("CUS_EMAIL"));
            customer.setCUS_FIRSTNAME(jsonObject.getString("CUS_FIRSTNAME"));
            customer.setCUS_ID(jsonObject.getInt("CUS_ID"));
            customer.setCUS_LASTNAME(jsonObject.getString("CUS_LASTNAME"));
            customer.setCUS_PASS(jsonObject.getString("CUS_PASS"));
            customer.setCUS_PHONE(jsonObject.getString("CUS_PHONE"));
            //Get date object from JSon Object
            String date=jsonObject.getString("CUS_REGISTRATION_DATE");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date regisDate=sdf.parse(date);
            customer.setCUS_REGISTRATION_DATE(regisDate);
            return customer;
        }
        catch (Exception ex)
        {
            Log.e("SIGN_LOG",ex.toString());
        }
        return null;
    }
}
