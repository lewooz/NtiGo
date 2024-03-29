package com.levent.ntigo.KuruKontakSensors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DigiSensorEnviromux {

    @SerializedName("data")
    @Expose
    private DigiSensorData data;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;

    public DigiSensorData getData() {
        return data;
    }

    public void setData(DigiSensorData data) {
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
