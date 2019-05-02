package com.e9ine.android.driver.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Surendar D on 30,April,2019
 */
public class Example extends BaseModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    public PhoneObj phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhoneObj getPhone() {
        return phone;
    }

    public void setPhone(PhoneObj phone) {
        this.phone = phone;
    }
}
