package com.wip.rayyacub.favoritecontacts.Adapter;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wip.rayyacub.favoritecontacts.ContactFragment;
import com.wip.rayyacub.favoritecontacts.MainActivity;
import com.wip.rayyacub.favoritecontacts.Model.Contact;
import com.wip.rayyacub.favoritecontacts.R;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {


    private List<Contact> contactList;
    private MainActivity mainActivity;

    public ContactsAdapter(List<Contact> contactList, MainActivity mainActivity) {
        this.contactList = contactList;
        this.mainActivity = mainActivity;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactsViewHolder holder, int position) {

        final Contact contact = contactList.get(position);
        //checking for favorites
        Boolean favorite = contact.getIsFavorite();
        if (favorite) {
            Glide.with(mainActivity).load(R.mipmap.favorite_true).into(holder.contactFavorite);
        } else {
            Glide.with(mainActivity).load(R.mipmap.favorite_false).into(holder.contactFavorite);
        }
        Glide.with(mainActivity).load(contact.getSmallImageURL()).into(holder.contactImage);

        holder.contactName.setText(contact.getName());
        holder.contactCompany.setText(contact.getCompanyName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactFragment contactFragment = new ContactFragment();
                Bundle contactsBundle = new Bundle();
                contactsBundle.putInt("position",holder.getAdapterPosition());
                contactsBundle.putParcelable("contacts", Parcels.wrap(contactList));
                contactFragment.setArguments(contactsBundle);
                FragmentTransaction transaction = mainActivity.getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.contact_list, contactFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.contact_row)
        RelativeLayout relativeLayout;
        @BindView(R.id.contact_image)
        ImageView contactImage;
        @BindView(R.id.contact_favorite)
        ImageView contactFavorite;
        @BindView(R.id.contact_name)
        TextView contactName;
        @BindView(R.id.contact_company)
        TextView contactCompany;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
