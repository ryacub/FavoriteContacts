package com.wip.rayyacub.favoritecontacts.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Phone {
    @SerializedName("work")
    @Expose
     String work;
    @SerializedName("home")
    @Expose
     String home;
    @SerializedName("mobile")
    @Expose
     String mobile;

    public Phone() {
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

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
