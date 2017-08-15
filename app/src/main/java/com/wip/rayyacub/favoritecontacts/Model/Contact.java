package com.wip.rayyacub.favoritecontacts.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Contact {
    @SerializedName("name")
    @Expose
     String name;
    @SerializedName("id")
    @Expose
     String id;
    @SerializedName("companyName")
    @Expose
     String companyName;
    @SerializedName("isFavorite")
    @Expose
     Boolean isFavorite;
    @SerializedName("smallImageURL")
    @Expose
     String smallImageURL;
    @SerializedName("largeImageURL")
    @Expose
     String largeImageURL;
    @SerializedName("emailAddress")
    @Expose
     String emailAddress;
    @SerializedName("birthdate")
    @Expose
     String birthdate;
    @SerializedName("phone")
    @Expose
     Phone phone;
    @SerializedName("address")
    @Expose
     Address address;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
