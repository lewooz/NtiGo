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
import android.widget.TextView;

import com.levent.ntigo.InternalSensors.InteriorSensorInfo;
import com.levent.ntigo.adapters.InteriorSensorAdapter;

import java.util.ArrayList;
import java.util.List;

public class InteriorSensorInfoActivity extends AppCompatActivity {

    List<InteriorSensorInfo> list;
    RecyclerView recyclerView;
    InteriorSensorAdapter adapter;
    Toolbar toolbar;
    GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior_sensor_info);

        toolbar=findViewById(R.id.dahili_sensor_toolbar);

        AnimationDrawable animationDrawable = (AnimationDrawable) toolbar.getBackground();
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.setEnterFadeDuration(1500);
        animationDrawable.start();

        list= new ArrayList<>();
        list = (List<InteriorSensorInfo>) getIntent().getSerializableExtra("interiorSensorList");

        recyclerView=findViewById(R.id.dahili_sensor_recyclerview);
        adapter= new InteriorSensorAdapter(InteriorSensorInfoActivity.this,list,getLayoutInflater(),getSupportFragmentManager());
        int no= calculateNoOfColumns(InteriorSensorInfoActivity.this,170);


        gridLayoutManager = new GridLayoutManager(this,no);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}
