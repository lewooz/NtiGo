package com.levent.ntigo.DeviceInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceInfoData {

    @SerializedName("device")
    @Expose
    private DeviceInfoDevice device;

    public DeviceInfoDevice getDevice() {
        return device;
    }

    public void setDevice(DeviceInfoDevice device) {
        this.device = device;
    }

}
