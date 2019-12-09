package com.levent.ntigo.HariciSensors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HariciSensorData {
    @SerializedName("esens")
    @Expose
    private List<Esen> esens = null;

    public List<Esen> getEsens() {
        return esens;
    }

    public void setEsens(List<Esen> esens) {
        this.esens = esens;
    }
}
