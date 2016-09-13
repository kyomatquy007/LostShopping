package com.kyo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kyo.lostshopping.R;
import com.kyo.model.CUSTOMER;

/**
 * Created by ASUS on 9/14/2016.
 */
public class ViDuAdapter extends ArrayAdapter<CUSTOMER> {

    Activity context;
    int resource;
    public ViDuAdapter(Activity context, int resource) {
        super(context, resource);
        //không có gì đặc biệt
        this.context=context;
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null); //tạo view

        //Khai báo control dựa theo vidu_adapter_layout
        //R.id.txtAccount_Adapter: R chọn com.kyo.lostshopping nó mới hiểu
        TextView txtAccount= (TextView) view.findViewById(R.id.txtAccount_Adapter);
        TextView txtPassword= (TextView) view.findViewById(R.id.txtPassword_Adapter);

        //Lấy vị trí, như láy ID
        //do ban đầu tạo class chỉ có public class ViDuAdapter extends ArrayAdapter<CUSTOMER>
        //nên có 1 table thì set data từ Image table được
        //còn hiện tại 2 table khác nhau, hàm getItem ở dưới nó không hiểu... kẹt chỗ này
        CUSTOMER cus=getItem(position);
        //set data từ database cho 2 cái Control mới khai báo ở trên
        txtAccount.setText(cus.getCUS_ACCOUNT());
        txtPassword.setText(cus.getCUS_PASS());

        return view;
    }
}
