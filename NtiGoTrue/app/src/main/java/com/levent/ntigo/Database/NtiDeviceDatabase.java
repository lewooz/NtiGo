package com.levent.ntigo.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.levent.ntigo.Interfaces.NtiDeviceInterface;
import com.levent.ntigo.model.NtiDevice;

@Database(entities = {NtiDevice.class},version = 1,exportSchema = false)
public abstract class NtiDeviceDatabase extends RoomDatabase {

    public abstract NtiDeviceInterface getNtiDeviceDao();

}
