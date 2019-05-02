package com.e9ine.android.driver.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Surendar D on 30,April,2019
 */
public class PhoneObj extends BaseModel {
    @SerializedName("home")
    @Expose
    public String home;
    @SerializedName("mobile")
    @Expose
    public String mobile;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
