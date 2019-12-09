package com.levent.ntigo.IpDevices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IpDevicesEnviromux {

    @SerializedName("data")
    @Expose
    private IpDevicesData data;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;

    public IpDevicesData getData() {
        return data;
    }

    public void setData(IpDevicesData data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
