package com.kyo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kyo.lostshopping.R;
import com.kyo.model.CATEGORY;
import com.kyo.model.PRODUCT;

/**
 * Created by ASUS on 9/12/2016.
 */
public class PRODUCTAdapter extends ArrayAdapter<PRODUCT> {

    Activity context;
    int resource;
    CATEGORY category=new CATEGORY();
    public PRODUCTAdapter(Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null);

        ImageView imgProducts= (ImageView) view.findViewById(R.id.imgProducts);
        TextView txtPrice= (TextView) view.findViewById(R.id.txtPrice);

        PRODUCT product=getItem(position);
        imgProducts.setImageBitmap(product.getBitMapOfImage());
        txtPrice.setText(product.getPRO_SALE_UNIT_PRICE()+" VNĐ");

        //create content view...

        return view;
    }
}
