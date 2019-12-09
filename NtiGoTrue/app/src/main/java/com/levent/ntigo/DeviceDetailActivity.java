package com.levent.ntigo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontStyle;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.levent.ntigo.DeviceInfo.DeviceInfoData;
import com.levent.ntigo.DeviceInfo.DeviceInfoEnviromux;
import com.levent.ntigo.DeviceLoginModels.Session;
import com.levent.ntigo.HariciSensors.Esen;
import com.levent.ntigo.HariciSensors.HariciSensorEnviromux;
import com.levent.ntigo.Interfaces.PostAppInterface;
import com.levent.ntigo.InternalSensors.InteriorSensorEnviromux;
import com.levent.ntigo.InternalSensors.InteriorSensorGetList;
import com.levent.ntigo.InternalSensors.InteriorSensorInfo;
import com.levent.ntigo.IpDevices.IpDevicesEnviromux;
import com.levent.ntigo.IpDevices.Ipdev;
import com.levent.ntigo.KuruKontakSensors.DigiSensorEnviromux;
import com.levent.ntigo.KuruKontakSensors.Diginp;
import com.levent.ntigo.RetrofitInstance.RetrofitInstance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceDetailActivity extends AppCompatActivity {

    TextView cihazname,cihazmodel,cihazuptime,cihazfirmware;
    String cihaznameS,cihazmodelS,cihazuptimeS,cihazfirmwareS,cookie, cihazipS, cihazUsernameS, cihazPasswordS;
    AlertDialog dahiliSensorAlertDialog;

    RelativeLayout ustLayout;
    Button icsensor,haricisensor, kurukontaksensor, ipcihazlar;
    List<InteriorSensorInfo> interiorSensorInfoList;
    List<Esen> hariciSensorInfoList;
    List<Diginp> digiSensorInfoList;
    List<Ipdev> ipDevicesInfoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        cihazmodel=findViewById(R.id.cihaz_model);
        cihazname=findViewById(R.id.cihaz_adı);
        cihazfirmware=findViewById(R.id.cihaz_firmware);
        cihazuptime=findViewById(R.id.cihaz_uptime);

        icsensor=findViewById(R.id.ic_sensör_image);
        haricisensor=findViewById(R.id.harici_sensor_image);
        kurukontaksensor=findViewById(R.id.kuru_kontak_image);
        ipcihazlar=findViewById(R.id.ip_devices_image);
        ustLayout=findViewById(R.id.üst_relative);

        interiorSensorInfoList= new ArrayList<>();
        hariciSensorInfoList= new ArrayList<>();
        ipDevicesInfoList= new ArrayList<>();

        cihaznameS=getIntent().getStringExtra("devicename");
        cihazmodelS=getIntent().getStringExtra("devicemodel");
        cihazuptimeS=getIntent().getStringExtra("deviceuptime");
        cihazfirmwareS=getIntent().getStringExtra("devicefirmware");
        cihazipS=getIntent().getStringExtra("deviceip");
        cihazUsernameS=getIntent().getStringExtra("username");
        cihazPasswordS=getIntent().getStringExtra("password");

        String nameTxt = "Device Name: "+cihaznameS;
        String modelTxt = "Model: "+cihazmodelS;
        String uptimeTxt = "Uptime: "+cihazuptimeS;
        String firmwareTxt = "Firmware: "+cihazfirmwareS;

        Spannable spannable = new SpannableString(nameTxt);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#432E69")), 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable2 = new SpannableString(modelTxt);
        spannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#432E69")), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable3 = new SpannableString(uptimeTxt);
        spannable3.setSpan(new ForegroundColorSpan(Color.parseColor("#432E69")), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable4 = new SpannableString(firmwareTxt);
        spannable4.setSpan(new ForegroundColorSpan(Color.parseColor("#432E69")), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        cihazname.setText(spannable, TextView.BufferType.SPANNABLE);
        cihazmodel.setText(spannable2, TextView.BufferType.SPANNABLE);
        cihazuptime.setText(spannable3, TextView.BufferType.SPANNABLE);
        cihazfirmware.setText(spannable4, TextView.BufferType.SPANNABLE);

        View gettingInfoDialogView = getLayoutInflater().inflate(R.layout.getting_info_dialog,null,false);
        dahiliSensorAlertDialog= new AlertDialog.Builder(this).create();
        dahiliSensorAlertDialog.setView(gettingInfoDialogView);
        dahiliSensorAlertDialog.setCanceledOnTouchOutside(false);


        AnimationDrawable dahiliAnimationDrawable= (AnimationDrawable) icsensor.getBackground();
        dahiliAnimationDrawable.setExitFadeDuration(1000);
        dahiliAnimationDrawable.setEnterFadeDuration(1500);

        AnimationDrawable hariciAnimationDrawable= (AnimationDrawable) haricisensor.getBackground();
        hariciAnimationDrawable.setExitFadeDuration(1000);
        hariciAnimationDrawable.setEnterFadeDuration(1500);

        AnimationDrawable kurukontakAnimationDrawable= (AnimationDrawable) kurukontaksensor.getBackground();
        kurukontakAnimationDrawable.setExitFadeDuration(1000);
        kurukontakAnimationDrawable.setEnterFadeDuration(1500);

        AnimationDrawable ipCihazlarAnimationDrawable= (AnimationDrawable) ipcihazlar.getBackground();
        ipCihazlarAnimationDrawable.setExitFadeDuration(1000);
        ipCihazlarAnimationDrawable.setEnterFadeDuration(1500);

        AnimationDrawable infoBannerAnimationDrawable= (AnimationDrawable) ustLayout.getBackground();
        infoBannerAnimationDrawable.setExitFadeDuration(2000);
        infoBannerAnimationDrawable.setEnterFadeDuration(1000);



        dahiliAnimationDrawable.start();
        hariciAnimationDrawable.start();
        kurukontakAnimationDrawable.start();
        ipCihazlarAnimationDrawable.start();
        infoBannerAnimationDrawable.start();



    }

    public void interiorsensor(View view)

    {
        dahiliSensorAlertDialog.show();
        final PostAppInterface postAppInterface = RetrofitInstance.getService();
        Call<Session> call = postAppInterface.getSess("http://"+cihazipS+"/goform/login",cihazUsernameS,cihazPasswordS);
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {

                cookie=response.body().getCookie();
                System.out.println("COOKIE:"+cookie);

                Call<InteriorSensorEnviromux> callTwo=postAppInterface.getInteriorSensorData("http://"+cihazipS+"/json/get/appISens.json",cookie);
                callTwo.enqueue(new Callback<InteriorSensorEnviromux>() {
                    @Override
                    public void onResponse(Call<InteriorSensorEnviromux> call, Response<InteriorSensorEnviromux> response) {

                        InteriorSensorEnviromux interiorSensorEnviromux = response.body();
                        interiorSensorInfoList = interiorSensorEnviromux.getInteriorSensorGetList().getIsens();
                        Intent intent = new Intent(DeviceDetailActivity.this,InteriorSensorInfoActivity.class);
                        intent.putExtra("interiorSensorList", (Serializable) interiorSensorInfoList);
                        startActivity(intent);
                        dahiliSensorAlertDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<InteriorSensorEnviromux> call, Throwable t) {

                        dahiliSensorAlertDialog.dismiss();
                    }
                });

            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {

                dahiliSensorAlertDialog.dismiss();
            }
        });

    }

    public void haricisensor(View view)
    {
        dahiliSensorAlertDialog.show();
        final PostAppInterface postAppInterface = RetrofitInstance.getService();
        Call<Session> call = postAppInterface.getSess("http://"+cihazipS+"/goform/login",cihazUsernameS,cihazPasswordS);
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {

                cookie=response.body().getCookie();
                System.out.println("COOKIE:"+cookie);

                Call<HariciSensorEnviromux> callTwo=postAppInterface.getHariciSensorData("http://"+cihazipS+"/json/get/appESens.json",cookie);
                callTwo.enqueue(new Callback<HariciSensorEnviromux>() {
                    @Override
                    public void onResponse(Call<HariciSensorEnviromux> call, Response<HariciSensorEnviromux> response) {

                        HariciSensorEnviromux hariciSensorEnviromux = response.body();
                        hariciSensorInfoList = hariciSensorEnviromux.getData().getEsens();
                        Intent intent = new Intent(DeviceDetailActivity.this,HariciSensorInfoActivity.class);
                        intent.putExtra("hariciSensorList", (Serializable) hariciSensorInfoList);
                        startActivity(intent);
                        dahiliSensorAlertDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<HariciSensorEnviromux> call, Throwable t) {

                        dahiliSensorAlertDialog.dismiss();
                    }
                });

            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {

                dahiliSensorAlertDialog.dismiss();
            }
        });

    }

    public void digisensor(View view)
    {
        dahiliSensorAlertDialog.show();
        final PostAppInterface postAppInterface = RetrofitInstance.getService();
        Call<Session> call = postAppInterface.getSess("http://"+cihazipS+"/goform/login",cihazUsernameS,cihazPasswordS);
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {

                cookie=response.body().getCookie();
                System.out.println("COOKIE:"+cookie);

                Call<DigiSensorEnviromux> callTwo=postAppInterface.getDigiSensorData("http://"+cihazipS+"/json/get/appDiginp.json",cookie);
                callTwo.enqueue(new Callback<DigiSensorEnviromux>() {
                    @Override
                    public void onResponse(Call<DigiSensorEnviromux> call, Response<DigiSensorEnviromux> response) {

                        DigiSensorEnviromux digiSensorEnviromux = response.body();
                        digiSensorInfoList = digiSensorEnviromux.getData().getDiginp();
                        Intent intent = new Intent(DeviceDetailActivity.this,DigiSensorInfoActivity.class);
                        intent.putExtra("digiSensorList", (Serializable) digiSensorInfoList);
                        startActivity(intent);
                        dahiliSensorAlertDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<DigiSensorEnviromux> call, Throwable t) {

                        dahiliSensorAlertDialog.dismiss();
                    }
                });

            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {

                dahiliSensorAlertDialog.dismiss();
            }
        });
    }

    public void ipdevices(View view)
    {
        dahiliSensorAlertDialog.show();
        final PostAppInterface postAppInterface = RetrofitInstance.getService();
        Call<Session> call = postAppInterface.getSess("http://"+cihazipS+"/goform/login",cihazUsernameS,cihazPasswordS);
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {

                cookie=response.body().getCookie();
                System.out.println("COOKIE:"+cookie);

                Call<IpDevicesEnviromux> callTwo=postAppInterface.getIpDevicesData("http://"+cihazipS+"/json/get/appIpdev.json",cookie);
                callTwo.enqueue(new Callback<IpDevicesEnviromux>() {
                    @Override
                    public void onResponse(Call<IpDevicesEnviromux> call, Response<IpDevicesEnviromux> response) {

                        IpDevicesEnviromux ipDeviceEnviromux = response.body();
                        ipDevicesInfoList = ipDeviceEnviromux.getData().getIpdev();
                        Intent intent = new Intent(DeviceDetailActivity.this,IpDevicesInfoActivity.class);
                        intent.putExtra("ipDevicesList", (Serializable) ipDevicesInfoList);
                        startActivity(intent);
                        dahiliSensorAlertDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<IpDevicesEnviromux> call, Throwable t) {

                        dahiliSensorAlertDialog.dismiss();
                    }
                });

            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {

                dahiliSensorAlertDialog.dismiss();
            }
        });

    }



}
