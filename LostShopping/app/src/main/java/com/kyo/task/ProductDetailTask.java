package com.kyo.task;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.kyo.lostshopping.R;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ASUS on 9/16/2016.
 */
public class ProductDetailTask extends AsyncTask<String,Void,Bitmap> {
    Activity context;
    public ProductDetailTask(Activity context)
    {
        this.context=context;
    }
    ImageView imageView= (ImageView) this.context.findViewById(R.id.imgDetail);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String imageLink=params[0];
        try
        {
            URL url=new URL("http://192.168.56.1/lostshopping/hinhanh/"+imageLink);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            Bitmap bitmap=BitmapFactory.decodeStream(connection.getInputStream());
            return bitmap;
        }
        catch (Exception ex)
        {
            Log.e("Product Detail Error",ex.toString());
        }
        return null;
    }
}
