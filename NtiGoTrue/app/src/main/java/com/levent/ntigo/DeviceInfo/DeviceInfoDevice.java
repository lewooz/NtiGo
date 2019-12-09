package com.levent.ntigo.DeviceInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceInfoDevice {

    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("uptime")
    @Expose
    private String uptime;
    @SerializedName("firmware")
    @Expose
    private String firmware;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

}
