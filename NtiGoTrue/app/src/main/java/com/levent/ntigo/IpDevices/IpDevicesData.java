package com.levent.ntigo.IpDevices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IpDevicesData {

    @SerializedName("ipdev")
    @Expose
    private List<Ipdev> ipdev = null;

    public List<Ipdev> getIpdev() {
        return ipdev;
    }

    public void setIpdev(List<Ipdev> ipdev) {
        this.ipdev = ipdev;
    }
}
