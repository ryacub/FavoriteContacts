package com.wip.rayyacub.favoritecontacts;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wip.rayyacub.favoritecontacts.Adapter.ContactsAdapter;
import com.wip.rayyacub.favoritecontacts.Model.Contact;
import com.wip.rayyacub.favoritecontacts.Network.ApiClient;
import com.wip.rayyacub.favoritecontacts.Network.ApiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    public List<Contact> contactList = new ArrayList<>();
    private ContactsAdapter contactsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvInit();
        networkCall();
    }


    //recycler view initialization
    private void rvInit() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
    }

    //network call to get hockey roster
    private void networkCall() {
        ApiClient.getClient()
                .create(ApiService.class)
                .getContacts()
                .enqueue(new Callback<List<Contact>>() {
                    @Override
                    public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                        contactList = response.body();
                        Collections.sort(contactList,new FavoritesSort());
                        contactsAdapter = new ContactsAdapter(contactList,MainActivity.this);
                        recyclerView.setAdapter(contactsAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Contact>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "call failure" + call.request().url(), Toast.LENGTH_LONG).show();

                    }
                });

    }
    //comparator class
    public class FavoritesSort implements Comparator<Contact> {


        @Override
        public int compare(Contact o1, Contact o2) {
            return o2.getIsFavorite().compareTo(o1.getIsFavorite());
        }
    }


}
