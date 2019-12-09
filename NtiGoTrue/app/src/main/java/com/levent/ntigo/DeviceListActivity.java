package com.levent.ntigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import com.levent.ntigo.Database.NtiDeviceDatabase;
import com.levent.ntigo.adapters.DeviceListAdapter;
import com.levent.ntigo.model.NtiDevice;

import java.util.List;

public class DeviceListActivity extends AppCompatActivity {


    Toolbar toolbar;
    NtiDeviceDatabase ntiDeviceDatabase;
    List<NtiDevice> deviceList;
    DeviceListAdapter adapter;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);


        recyclerView=findViewById(R.id.device_list_recycler_view);
        toolbar=findViewById(R.id.device_list_toolbar);
        setSupportActionBar(toolbar);


        ntiDeviceDatabase = Room.databaseBuilder(getApplicationContext(),NtiDeviceDatabase.class,"NtiDB")
                .allowMainThreadQueries()
                .build();

        deviceList=ntiDeviceDatabase.getNtiDeviceDao().getAllDevices();
        adapter= new DeviceListAdapter(DeviceListActivity.this,deviceList,getLayoutInflater());
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        DividerItemDecoration decoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    public void addDevice(View view)
{
    Intent intent = new Intent(DeviceListActivity.this,AddDeviceActivity.class);
    startActivity(intent);


}

}
