package com.kyo.lostshopping;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kyo.adapter.PRODUCTAdapter;
import com.kyo.model.CATEGORY;
import com.kyo.model.PRODUCT;
import com.kyo.task.AllProductTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btnChargers, btnGloves, btnShoes, btnBackPack, btnTrekking, btnMotoAccess, btnClothes
            ,btnHeadphones, btnCameras, btnWatches, btnDrones, btnSpeaker;
    LinearLayout llCategory;
    GridView gvProducts;
    PRODUCTAdapter productAdapter;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void addEvents() {
        /**
         * /Go to Product Detail when clicking on the Item
         * Pass Data of item to ProductDetailActivity to show them again in Product Detail
         */

        gvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PRODUCT pro=productAdapter.getItem(i);
                handlingProductDetail(pro);
            }
        });
    }

    private void handlingProductDetail(PRODUCT pro) {
        Intent intent=new Intent(MainActivity.this,ProductDetailActivity.class);
        intent.putExtra("PRO_ID",pro.getPRO_ID());
        intent.putExtra("PRO_IMAGE",pro.getPRO_IMAGE());
        intent.putExtra("PRO_SALE_UNIT_PRICE",(float)pro.getPRO_SALE_UNIT_PRICE());
        intent.putExtra("PRO_DES",pro.getPRO_DES());
        intent.putExtra("PRO_NAME",pro.getPRO_NAME());
        intent.putExtra("PRO_COLOR",pro.getPRO_COLOR());
        intent.putExtra("PRO_SUP_UNIT_PRICE",(float)pro.getPRO_SUP_UNIT_PRICE());
        startActivity(intent);
    }

    private void addControls() {
        btnBackPack= (Button) findViewById(R.id.btnBackPack);
        btnCameras= (Button) findViewById(R.id.btnCameras);
        btnChargers= (Button) findViewById(R.id.btnChargers);
        btnClothes= (Button) findViewById(R.id.btnClothes);
        btnDrones= (Button) findViewById(R.id.btnDrones);
        btnGloves= (Button) findViewById(R.id.btnGloves);
        btnHeadphones= (Button) findViewById(R.id.btnHeadphones);
        btnMotoAccess= (Button) findViewById(R.id.btnMotoAccess);
        btnShoes= (Button) findViewById(R.id.btnShoes);
        btnSpeaker= (Button) findViewById(R.id.btnSpeakers);
        btnTrekking= (Button) findViewById(R.id.btnTrekking);
        btnWatches= (Button) findViewById(R.id.btnWatches);
        llCategory= (LinearLayout) findViewById(R.id.llCategory);

        gvProducts= (GridView) findViewById(R.id.gvProducts);
        productAdapter=new PRODUCTAdapter(MainActivity.this,R.layout.product_item);
        gvProducts.setAdapter(productAdapter);

        navigationView= (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu=navigationView.getMenu();

        AllProductTask allProductTask=new AllProductTask(productAdapter);
        allProductTask.execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_share) {

        }

        /**
         * Update Profile Fragment
         * Not done(Bug: layout from fragment_update_profile overlap content_main layout)
         *
         else if(id==R.id.nav_update_profile){
            UpdateProfileFragment profileFragment=new UpdateProfileFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.linear_layout_main,profileFragment,profileFragment.getTag())
                    .commit();

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
