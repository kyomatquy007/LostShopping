package com.kyo.task;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.kyo.adapter.PRODUCTAdapter;
import com.kyo.model.PRODUCT;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ASUS on 9/15/2016.
 */
public class AllProductTask extends AsyncTask<Void,Void,ArrayList<PRODUCT>> {
    Activity context;
    PRODUCTAdapter adapter;

    public AllProductTask(Activity context)
    {
        this.context=context;
    }

    public AllProductTask(PRODUCTAdapter adapter)
    {
        this.adapter=adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.adapter.clear();
    }

    @Override
    protected void onPostExecute(ArrayList<PRODUCT> products) {
        super.onPostExecute(products);
        this.adapter.clear();
        this.adapter.addAll(products);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected ArrayList<PRODUCT> doInBackground(Void... param) {
        ArrayList<PRODUCT>productList=new ArrayList<>();
        try
        {
            URL url=new URL("http://192.168.56.1/lostshopping/api/product");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("content-type"," application/json; charset=utf-8");
            InputStreamReader isr=new InputStreamReader(connection.getInputStream(),"UTF-8");
            BufferedReader br=new BufferedReader(isr);
            StringBuilder builder=new StringBuilder();
            String line=br.readLine();
            while(line!=null)
            {
                builder.append(line);
                line=br.readLine();
            }
            String jsonFormat=builder.toString();
            JSONArray jsonArray=new JSONArray(jsonFormat);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                PRODUCT pro=new PRODUCT();
                pro.setPRO_ID(jsonObject.getInt("PRO_ID"));
                pro.setPRO_COLOR(jsonObject.getString("PRO_COLOR"));
                if(!jsonObject.isNull("PRO_DEPTH"))
                    pro.setPRO_DEPTH((float)jsonObject.getDouble("PRO_DEPTH"));
                pro.setPRO_DES(jsonObject.getString("PRO_DES"));
                if(!jsonObject.isNull("PRO_DIAMETER"))
                    pro.setPRO_DIAMETER((float)jsonObject.getDouble("PRO_DIAMETER"));
                if(!jsonObject.isNull("PRO_DISCOUNT_AVAILABLE"))
                    pro.setPRO_DISCOUNT_AVAILABLE((float)jsonObject.getDouble("PRO_DISCOUNT_AVAILABLE"));
                if(!jsonObject.isNull("PRO_DISCOUNT_PERCENT"))
                    pro.setPRO_DISCOUNT_PERCENT((float)jsonObject.getDouble("PRO_DISCOUNT_PERCENT"));
                pro.setPRO_IMAGE(jsonObject.getString("PRO_IMAGE"));
                if(!jsonObject.isNull("PRO_LENGTH"))
                    pro.setPRO_LENGTH((float)jsonObject.getDouble("PRO_LENGTH"));
                pro.setPRO_NAME(jsonObject.getString("PRO_NAME"));
                if(!jsonObject.isNull("PRO_SALE_UNIT_PRICE"))
                    pro.setPRO_SALE_UNIT_PRICE((float)jsonObject.getDouble("PRO_SALE_UNIT_PRICE"));
                pro.setPRO_SUBCAT_ID(jsonObject.getInt("PRO_SUBCAT_ID"));
                if(!jsonObject.isNull("PRO_SUP_ID"))
                    pro.setPRO_SUP_ID(jsonObject.getInt("PRO_SUP_ID"));
                if(!jsonObject.isNull("PRO_SUP_QUANTITY"))
                    pro.setPRO_SUP_QUANTITY((float)jsonObject.getDouble("PRO_SUP_QUANTITY"));
                if(!jsonObject.isNull("PRO_SUP_UNIT_PRICE"))
                    pro.setPRO_SUP_UNIT_PRICE((float)jsonObject.getDouble("PRO_SUP_UNIT_PRICE"));
                if(!jsonObject.isNull("PRO_UNIT_WEIGHT"))
                    pro.setPRO_UNIT_WEIGHT((float)jsonObject.getDouble("PRO_UNIT_WEIGHT"));
                if(!jsonObject.isNull("PRO_WIDTH"))
                    pro.setPRO_WIDTH((float)jsonObject.getDouble("PRO_WIDTH"));

                String imageLink="http://192.168.56.1/lostshopping/hinhanh/"+pro.getPRO_IMAGE();
                URL urlImage=new URL(imageLink);
                connection= (HttpURLConnection) urlImage.openConnection();
                Bitmap bitmap= BitmapFactory.decodeStream(connection.getInputStream());
                pro.setBitMapOfImage(bitmap);

                productList.add(pro);
            }
        }
        catch (Exception ex)
        {
            Log.e("Show All Product Error",ex.toString());
        }
        return productList;
    }
}
