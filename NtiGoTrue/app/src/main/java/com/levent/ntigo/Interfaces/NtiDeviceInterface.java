package com.levent.ntigo.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.levent.ntigo.model.NtiDevice;

import java.util.List;

@Dao
public interface NtiDeviceInterface {

    @Insert
    void addDevice(NtiDevice ntiDevice);

    @Update
    void updateDevice(NtiDevice ntiDevice);

    @Delete
    void deleteDevice(NtiDevice ntiDevice);

    @Query("select * from Devices where numara==:numara")
    public NtiDevice getDevice(String numara);

    @Query("select * from Devices")
    public List<NtiDevice> getAllDevices();
}
