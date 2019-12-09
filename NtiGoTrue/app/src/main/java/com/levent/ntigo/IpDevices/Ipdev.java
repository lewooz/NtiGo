package com.levent.ntigo.IpDevices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ipdev implements Serializable {

    @SerializedName("idx")
    @Expose
    private Integer idx;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("val")
    @Expose
    private String val;
    @SerializedName("retries")
    @Expose
    private Integer retries;
    @SerializedName("timeout")
    @Expose
    private Integer timeout;
    @SerializedName("repeat")
    @Expose
    private Integer repeat;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

}
