package com.levent.ntigo.InternalSensors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InteriorSensorEnviromux {

    @SerializedName("data")
    @Expose
    private InteriorSensorGetList interiorSensorGetList;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;

    public InteriorSensorGetList getInteriorSensorGetList() {
        return interiorSensorGetList;
    }

    public void setData(InteriorSensorGetList interiorSensorGetList) {
        this.interiorSensorGetList = interiorSensorGetList;
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
