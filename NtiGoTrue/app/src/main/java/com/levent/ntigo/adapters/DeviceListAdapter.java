package com.levent.ntigo.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.levent.ntigo.Database.NtiDeviceDatabase;
import com.levent.ntigo.DeviceDetailActivity;
import com.levent.ntigo.DeviceInfo.DeviceInfoData;
import com.levent.ntigo.DeviceInfo.DeviceInfoDevice;
import com.levent.ntigo.DeviceInfo.DeviceInfoEnviromux;
import com.levent.ntigo.DeviceListActivity;
import com.levent.ntigo.DeviceLoginModels.Session;
import com.levent.ntigo.Interfaces.PostAppInterface;
import com.levent.ntigo.R;
import com.levent.ntigo.RetrofitInstance.RetrofitInstance;
import com.levent.ntigo.model.NtiDevice;
import com.levent.ntigo.model.DeviceListVH;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListVH> {

    Context context;

    List<NtiDevice> deviceList;
    LayoutInflater layoutInflater;
    NtiDevice device;
    NtiDeviceDatabase ntiDeviceDatabase;
    AlertDialog alertDialog;

    HashMap<String, Object> map;
    String cookie;
    DeviceInfoDevice deviceInfoDevice;

    public DeviceListAdapter(Context context, List<NtiDevice> deviceList, LayoutInflater layoutInflater) {
        this.context = context;
        this.deviceList = deviceList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public DeviceListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= layoutInflater.inflate(R.layout.row_device_list,parent,false);

        DeviceListVH holdervh = new DeviceListVH(view);

        return holdervh;
    }

    @Override
    public void onBindViewHolder(@NonNull final DeviceListVH holder, final int position) {

        device = deviceList.get(position);

        holder.deviceNametxt.setText(device.getName());
        holder.deviceIpNotxt.setText(device.getNumara());
        holder.deviceModeltxt.setText(device.getModel());
        holder.usernametxt.setText("Username: "+device.getUsername());
        holder.passwordtxt.setText("Password: "+device.getPassword());


        if(device.getModel().equals("NTI 2-D"))
        {
            holder.deviceImage.setImageResource(R.drawable.nti2dm);
        }else if(device.getModel().equals("NTI 5-D"))
        {
            holder.deviceImage.setImageResource(R.drawable.nti5dm);

        }else if(device.getModel().equals("NTI 16-D"))
        {
            holder.deviceImage.setImageResource(R.drawable.nti16dm);
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Button redButon,kabulButon;
                alertDialog = new AlertDialog.Builder(context).create();
                View view2 = layoutInflater.inflate(R.layout.delete_device_alert_dialog,null,false);
                alertDialog.setView(view2);
                alertDialog.setCanceledOnTouchOutside(false);
                redButon = view2.findViewById(R.id.red_button);
                kabulButon= view2.findViewById(R.id.kabul_button);
                alertDialog.show();
                redButon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                kabulButon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        ntiDeviceDatabase = Room.databaseBuilder(context,NtiDeviceDatabase.class,"NtiDB")
                                .allowMainThreadQueries()
                                .build();


                                ntiDeviceDatabase.getNtiDeviceDao().deleteDevice(device);
                                alertDialog.dismiss();
                                Toast.makeText(context,"Device Deleted",Toast.LENGTH_LONG).show();
                                deviceList.remove(position);
                                notifyItemRemoved(position);
                                notifyDataSetChanged();



                    }
                });

                return false;
            }
        });

        holder.connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                device=deviceList.get(position);

                View view3 = layoutInflater.inflate(R.layout.connect_device_dialog,null,false);
                final AlertDialog connectDialog= new AlertDialog.Builder(context).create();
                connectDialog.setView(view3);
                connectDialog.setCanceledOnTouchOutside(false);
                connectDialog.show();
                String kontrol = "http://"+device.getNumara()+"/json/get/appDevice.json";

                final PostAppInterface postAppInterface = RetrofitInstance.getService();
                Call<Session> call = postAppInterface.getSess("http://"+device.getNumara()+"/goform/login",device.getUsername(),device.getPassword());

                call.enqueue(new Callback<Session>() {
                    @Override
                    public void onResponse(Call<Session> call, Response<Session> response) {

                        cookie=response.body().getCookie();
                        System.out.println("COOKIE:"+cookie);

                        Call<DeviceInfoEnviromux> calltwo = postAppInterface.getDeviceInfoData("http://"+device.getNumara()+"/json/get/appDevice.json",cookie);
                        calltwo.enqueue(new Callback<DeviceInfoEnviromux>() {
                            @Override
                            public void onResponse(Call<DeviceInfoEnviromux> call, Response<DeviceInfoEnviromux> response) {

                                new DeviceInfoEnviromux();
                                DeviceInfoEnviromux deviceInfoEnviromux;
                                deviceInfoEnviromux =response.body();
                                DeviceInfoData deviceInfoData = deviceInfoEnviromux.getData();
                                deviceInfoDevice=deviceInfoData.getDevice();

                                Intent intent = new Intent(context, DeviceDetailActivity.class);
                                intent.putExtra("devicename",deviceInfoDevice.getUnit());
                                intent.putExtra("devicefirmware",deviceInfoDevice.getFirmware());
                                intent.putExtra("devicemodel",deviceInfoDevice.getModel());
                                intent.putExtra("deviceuptime",deviceInfoDevice.getUptime());
                                intent.putExtra("deviceip",device.getNumara());
                                intent.putExtra("username",device.getUsername());
                                intent.putExtra("password",device.getPassword());


                                context.startActivity(intent);
                                Toast.makeText(context,"Connection successfull.",Toast.LENGTH_LONG).show();
                                connectDialog.dismiss();


                            }

                            @Override
                            public void onFailure(Call<DeviceInfoEnviromux> call, Throwable t) {

                                Toast.makeText(context.getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                connectDialog.dismiss();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Session> call, Throwable t) {


                        connectDialog.dismiss();

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }
}
