package com.example.scholarlysavings.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scholarlysavings.ProfileAdapter;
import com.example.scholarlysavings.R;
import com.example.scholarlysavings.UserInfo;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";
    private RecyclerView rvProfile;
    private ProfileAdapter adapter;
    private List<UserInfo> allinfo;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvProfile = view.findViewById(R.id.rvProfile);

        allinfo = new ArrayList<>();
        adapter = new ProfileAdapter(getContext(), allinfo);

        rvProfile.setAdapter(adapter);
        rvProfile.setLayoutManager(new LinearLayoutManager(getContext()));
        queryProfile();
    }

    public void queryProfile(){
        ParseQuery<UserInfo> query = ParseQuery.getQuery(UserInfo.class);
        query.include(UserInfo.KEY_USER);
        query.whereEqualTo(UserInfo.KEY_USER, ParseUser.getCurrentUser());
        query.findInBackground(new FindCallback<UserInfo>() {
            @Override
            public void done(List<UserInfo> info, ParseException e) {

                for (UserInfo information : info) {
                    Log.i(TAG, "Name: " + information.getName() + ", Phone: " + information.getPhone());
                }
                allinfo.addAll(info);
                adapter.notifyDataSetChanged();
            }
        });
    }
}