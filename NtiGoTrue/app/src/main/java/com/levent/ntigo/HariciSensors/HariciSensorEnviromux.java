package com.levent.ntigo.HariciSensors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HariciSensorEnviromux {

    @SerializedName("data")
    @Expose
    private HariciSensorData data;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;

    public HariciSensorData getData() {
        return data;
    }

    public void setData(HariciSensorData data) {
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
