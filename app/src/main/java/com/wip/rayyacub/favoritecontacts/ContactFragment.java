package com.wip.rayyacub.favoritecontacts;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wip.rayyacub.favoritecontacts.Model.Address;
import com.wip.rayyacub.favoritecontacts.Model.Contact;
import com.wip.rayyacub.favoritecontacts.Model.Phone;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactFragment extends Fragment {
    @BindView(R.id.contact_favorite)
    ImageView star;
    @BindView(R.id.contact_image)
    ImageView image;
    @BindView(R.id.contact_name)
    TextView name;
    @BindView(R.id.contact_company)
    TextView company;
    @BindView(R.id.phone_home)
    LinearLayout homeNumberLayout;
    @BindView(R.id.phone_home_number)
    TextView homeNumber;
    @BindView(R.id.phone_mobile)
    LinearLayout mobileNumberLayout;
    @BindView(R.id.phone_mobile_number)
    TextView mobileNumber;
    @BindView(R.id.phone_work)
    LinearLayout workNumberLayout;
    @BindView(R.id.phone_work_number)
    TextView workNumber;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.birthday)
    TextView birthday;
    @BindView(R.id.email)
    TextView email;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, rootView);
        setHasOptionsMenu(true);
        initValues();
        return rootView;
    }

    private void initValues() {

        //retrieving the parcels
        List<Contact> contactlist = Parcels.unwrap(getArguments().getParcelable("contacts"));
        int position = getArguments().getInt("position");

        //creating contact, address, phone objects
        Contact contact = contactlist.get(position);
        Address contactAddress = contact.getAddress();
        Phone contactPhone = contact.getPhone();

        //setting up the values
        Boolean favorite = contact.getIsFavorite();
        Boolean clickState = favorite;
        if (favorite) {
            Glide.with(getActivity()).load(R.mipmap.favorite_true).into(star);
        } else {
            Glide.with(getActivity()).load(R.mipmap.favorite_false).into(star);
        }
        Glide.with(getActivity()).load(contact.getLargeImageURL()).into(image);
        star.setOnClickListener(new favoriteContact(clickState, contact));
        name.setText(contact.getName());
        company.setText(contact.getCompanyName());

        String homePhone = contactPhone.getHome();
        String mobilePhone = contactPhone.getMobile();
        String workPhone = contactPhone.getWork();
        //null checks for phone fields and visibility handling
        if (homePhone == null) {
            homeNumberLayout.setVisibility(View.GONE);
        } else {
            homeNumber.setText(homePhone);
        }
        if (mobilePhone == null) {
            mobileNumberLayout.setVisibility(View.GONE);
        } else {
            mobileNumber.setText(homePhone);
        }
        if (workPhone == null) {
            workNumberLayout.setVisibility(View.GONE);
        } else {
            workNumber.setText(homePhone);
        }

        String addressFormatted = contactAddress.getStreet() + "\n" + contactAddress.getCity() + ", " + contactAddress.getState() + " " + contactAddress.getZipCode()
                + ", " + contactAddress.getCountry();
        address.setText(addressFormatted);
        birthday.setText(contact.getBirthdate());
        email.setText(contact.getEmailAddress());

    }


    //favorite on click listener
    private class favoriteContact implements View.OnClickListener {
        Boolean favorite;
        Contact contact;

        public favoriteContact(Boolean favorite, Contact contact) {
            this.favorite = favorite;
            this.contact = contact;
        }

        @Override
        public void onClick(View v) {
            if (favorite) {
                favorite = false;
                Glide.with(getActivity()).load(R.mipmap.favorite_false).into(star);
                contact.setIsFavorite(favorite);
            } else {
                favorite = true;
                Glide.with(getActivity()).load(R.mipmap.favorite_true).into(star);
                contact.setIsFavorite(favorite);
            }

        }
    }

}
