package com.levent.ntigo.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Devices")
public class NtiDevice {

    private String name, username, password, model;

    @PrimaryKey
    @NonNull
    private String numara;

    @Ignore
    public NtiDevice() {
    }

    public NtiDevice(String name, String username, String password, String model, @NonNull String numara) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.model = model;
        this.numara = numara;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NonNull
    public String getNumara() {
        return numara;
    }

    public void setNumara(@NonNull String numara) {
        this.numara = numara;
    }
}
