package com.kyo.lostshopping;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

import com.kyo.model.PRODUCT;
import com.kyo.task.ProductDetailTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView txtPriceDetail;
    PRODUCT pro=new PRODUCT();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        imgDetail= (ImageView) findViewById(R.id.imgDetail);
        txtPriceDetail= (TextView) findViewById(R.id.txtDetailPrice);

        Intent intent=getIntent();
        int pro_id=intent.getIntExtra("PRO_ID",0);
        String pro_image=intent.getStringExtra("PRO_IMAGE");
        float pro_sale_unit_price=intent.getFloatExtra("PRO_SALE_UNIT_PRICE",0);

        txtPriceDetail.setText(pro_sale_unit_price+" VNĐ");

        //Crash when calling ProductDetailTask
        //ProductDetailTask detailTask=new ProductDetailTask(ProductDetailActivity.this);
        //detailTask.execute(pro_image);
        DetailTask detailTask=new DetailTask();
        detailTask.execute(pro_image);
    }

    public  class DetailTask extends AsyncTask<String,Void,Bitmap>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgDetail.setImageBitmap(bitmap);
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
}
