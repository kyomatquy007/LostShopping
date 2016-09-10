package com.kyo.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.kyo.model.CUSTOMER;

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
        if(b==true)
        {
            msg="Create success";
            Intent intent=new Intent(this.context,SignInTask.class);
            this.context.startActivity(intent);
        }

        Toast.makeText(this.context,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(CUSTOMER... customers) {
        return false;
    }
}
