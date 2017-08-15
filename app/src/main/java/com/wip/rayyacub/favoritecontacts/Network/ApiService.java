package com.wip.rayyacub.favoritecontacts.Network;


import com.wip.rayyacub.favoritecontacts.Model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("contacts.json")
    Call<List<Contact>> getContacts();
}
