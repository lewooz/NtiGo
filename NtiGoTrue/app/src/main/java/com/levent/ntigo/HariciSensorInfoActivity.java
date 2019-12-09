package com.levent.ntigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.levent.ntigo.HariciSensors.Esen;
import com.levent.ntigo.adapters.HariciSensorAdapter;

import java.util.ArrayList;
import java.util.List;

public class HariciSensorInfoActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    List<Esen> hariciSensorList;
    HariciSensorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harici_sensor_info);

        hariciSensorList=new ArrayList<>();
        hariciSensorList= (List<Esen>) getIntent().getSerializableExtra("hariciSensorList");
        adapter= new HariciSensorAdapter(this,hariciSensorList,getLayoutInflater(),getSupportFragmentManager());

        toolbar=findViewById(R.id.harici_sensor_toolbar);

        recyclerView=findViewById(R.id.harici_sensor_recyclerview);
        int no= calculateNoOfColumns(HariciSensorInfoActivity.this,170);

        linearLayoutManager=new LinearLayoutManager(this);
        gridLayoutManager= new GridLayoutManager(this,no);
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
