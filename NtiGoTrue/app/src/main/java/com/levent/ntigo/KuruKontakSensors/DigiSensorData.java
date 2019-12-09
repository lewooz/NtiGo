package com.levent.ntigo.KuruKontakSensors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DigiSensorData {

    @SerializedName("diginp")
    @Expose
    private List<Diginp> diginp = null;

    public List<Diginp> getDiginp() {
        return diginp;
    }

    public void setDiginp(List<Diginp> diginp) {
        this.diginp = diginp;
    }
}
