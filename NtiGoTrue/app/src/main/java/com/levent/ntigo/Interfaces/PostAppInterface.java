package com.levent.ntigo.Interfaces;

import com.levent.ntigo.DeviceInfo.DeviceInfoEnviromux;
import com.levent.ntigo.DeviceLoginModels.Session;
import com.levent.ntigo.HariciSensors.HariciSensorEnviromux;
import com.levent.ntigo.InternalSensors.InteriorSensorEnviromux;
import com.levent.ntigo.IpDevices.IpDevicesEnviromux;
import com.levent.ntigo.KuruKontakSensors.DigiSensorEnviromux;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PostAppInterface {

    @GET
    Call<Session> getSess(@Url String url, @Query("username") String username,
                          @Query("password") String pass);

    //@GET("/json/get/appIpdev.json")
    //Call<Enviromux> getDetails( @Header("cookie") String cookie);

    @GET
    Call<DeviceInfoEnviromux> getDeviceInfoData(@Url String url, @Header("cookie") String cookie);

    @GET
    Call<InteriorSensorEnviromux> getInteriorSensorData(@Url String url, @Header("cookie") String cookie);

    @GET
    Call<HariciSensorEnviromux> getHariciSensorData(@Url String url, @Header("cookie") String cookie);

    @GET
    Call<DigiSensorEnviromux> getDigiSensorData(@Url String url, @Header("cookie") String cookie);

    @GET
    Call<IpDevicesEnviromux> getIpDevicesData(@Url String url, @Header("cookie") String cookie);
}
