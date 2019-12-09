package com.levent.ntigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.levent.ntigo.Database.NtiDeviceDatabase;
import com.levent.ntigo.model.NtiDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddDeviceActivity extends AppCompatActivity {

    MaterialSpinner spinner;
    TextInputEditText ipNumber,username,name,password;
    NtiDeviceDatabase ntiDeviceDatabase;

    NtiDevice ntiDevice;
     AlertDialog addDeviceDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        View view = getLayoutInflater().inflate(R.layout.add_device_alert_dialog,null,false);

        addDeviceDialog= new AlertDialog.Builder(this).create();
        addDeviceDialog.setView(view);
        addDeviceDialog.setCanceledOnTouchOutside(false);


        spinner =findViewById(R.id.spinner);
        ipNumber=findViewById(R.id.ip_number_text);
        username=findViewById(R.id.username_text);
        name=findViewById(R.id.device_name_text);
        password=findViewById(R.id.password_text);

        ntiDeviceDatabase = Room.databaseBuilder(getApplicationContext(),NtiDeviceDatabase.class,"NtiDB")
                .allowMainThreadQueries()
                .build();

        spinner.setItems("NTI 2-D", "NTI 5-D", "NTI 16-D");


    }

    public void deviceadd(View view)
    {
        if(name.getText().toString().isEmpty() || username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || ipNumber.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(),"Lütfen tüm alanları doldurunuz.",Toast.LENGTH_LONG).show();
        }else {
            addDeviceDialog.show();
            List modelList;
            String model;
            int select;
            select = spinner.getSelectedIndex();

            modelList = spinner.getItems();
            model = modelList.get(select).toString();
            ntiDevice = new NtiDevice(name.getText().toString(), username.getText().toString(), password.getText().toString(), model, ipNumber.getText().toString());

            NtiDevice kontrolDevice = ntiDeviceDatabase.getNtiDeviceDao().getDevice(ipNumber.getText().toString());
            if (kontrolDevice == null) {


                            ntiDeviceDatabase.getNtiDeviceDao().addDevice(ntiDevice);
                            Toast.makeText(getApplicationContext(), "Ürün eklendi", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), DeviceListActivity.class);
                            startActivity(intent);
                            addDeviceDialog.dismiss();
                            finish();




            } else {
                Toast.makeText(getApplicationContext(), "Bu ürün daha önce zaten eklenmiş.", Toast.LENGTH_LONG).show();
                addDeviceDialog.dismiss();
            }
        }
    }

    }

