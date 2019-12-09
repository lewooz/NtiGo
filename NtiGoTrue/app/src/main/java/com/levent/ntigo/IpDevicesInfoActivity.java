package com.levent.ntigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.levent.ntigo.IpDevices.Ipdev;
import com.levent.ntigo.adapters.IpDevicesAdapter;

import java.util.ArrayList;
import java.util.List;


public class IpDevicesInfoActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<Ipdev> list;
    RecyclerView recyclerView;
    int no;
    GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_devices_info);

        toolbar=findViewById(R.id.ipdevices_toolbar);
        recyclerView=findViewById(R.id.ipdevices_recyclerview);
        list= new ArrayList<>();

        no=calculateNoOfColumns(IpDevicesInfoActivity.this,170);
        gridLayoutManager= new GridLayoutManager(this,no);

        list= (List<Ipdev>) getIntent().getSerializableExtra("ipDevicesList");

        IpDevicesAdapter adapter;

        adapter= new IpDevicesAdapter(IpDevicesInfoActivity.this,list,getLayoutInflater(),getSupportFragmentManager());


        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);



        AnimationDrawable animationDrawable=(AnimationDrawable) toolbar.getBackground();
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.setEnterFadeDuration(1500);
        animationDrawable.start();
    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}
