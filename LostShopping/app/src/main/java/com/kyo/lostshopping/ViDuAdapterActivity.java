package com.kyo.lostshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kyo.adapter.ViDuAdapter;

public class ViDuAdapterActivity extends AppCompatActivity {

    ListView lvViDuAdapter;
    ViDuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_du_adapter);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvViDuAdapter= (ListView) findViewById(R.id.lvViDuAdapter); //khai báo Control
        adapter=new ViDuAdapter(ViDuAdapterActivity.this,R.layout.activity_vi_du_adapter); //gán layout cho adapter
        lvViDuAdapter.setAdapter(adapter);

        //ở đây gọi hàm bên folder" task" để gọi web service về thực thi lệnh show dữ liệu, này để t viết -_-
    }
}
