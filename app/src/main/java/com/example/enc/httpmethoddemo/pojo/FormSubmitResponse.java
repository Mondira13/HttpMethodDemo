package com.example.enc.httpmethoddemo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FormSubmitResponse {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("name")
    @Expose
    private String name;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
