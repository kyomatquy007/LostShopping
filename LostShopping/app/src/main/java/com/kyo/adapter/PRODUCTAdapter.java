package com.kyo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.kyo.model.PRODUCT;

/**
 * Created by ASUS on 9/12/2016.
 */
public class PRODUCTAdapter extends ArrayAdapter<PRODUCT> {

    Activity context;
    int resource;
    public PRODUCTAdapter(Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null);

        //create content view...

        return view;
    }
}
