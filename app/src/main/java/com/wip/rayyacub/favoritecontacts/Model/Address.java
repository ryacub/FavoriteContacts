package com.wip.rayyacub.favoritecontacts.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Address {

    @SerializedName("street")
    @Expose
     String street;
    @SerializedName("city")
    @Expose
     String city;
    @SerializedName("state")
    @Expose
     String state;
    @SerializedName("country")
    @Expose
     String country;
    @SerializedName("zipCode")
    @Expose
     String zipCode;
    public Address(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
