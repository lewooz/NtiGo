package com.levent.ntigo.InternalSensors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InteriorSensorGetList {

    @SerializedName("isens")
    @Expose
    private List<InteriorSensorInfo> isens = null;

    public List<InteriorSensorInfo> getIsens() {
        return isens;
    }

    public void setIsens(List<InteriorSensorInfo> isens) {
        this.isens = isens;
    }
}
