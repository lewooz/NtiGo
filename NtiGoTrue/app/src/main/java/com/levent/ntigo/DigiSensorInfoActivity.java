package com.levent.ntigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.levent.ntigo.HariciSensors.Esen;
import com.levent.ntigo.KuruKontakSensors.Diginp;
import com.levent.ntigo.adapters.DigitalSensorAdapter;
import com.levent.ntigo.adapters.HariciSensorAdapter;

import java.util.ArrayList;
import java.util.List;

public class DigiSensorInfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    GridLayoutManager gridLayoutManager;
    List<Diginp> digiSensorList;
    DigitalSensorAdapter adapter;
    int no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_sensor_info);

        recyclerView=findViewById(R.id.digi_sensor_recyclerview);

        digiSensorList= new ArrayList<>();
        digiSensorList= (List<Diginp>) getIntent().getSerializableExtra("digiSensorList");
        toolbar=findViewById(R.id.digi_sensor_toolbar);

        no = calculateNoOfColumns(this,170);
        gridLayoutManager= new GridLayoutManager(this,no);

        adapter= new DigitalSensorAdapter(DigiSensorInfoActivity.this,digiSensorList,getLayoutInflater(),getSupportFragmentManager());

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        AnimationDrawable animationDrawable= (AnimationDrawable) toolbar.getBackground();
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
