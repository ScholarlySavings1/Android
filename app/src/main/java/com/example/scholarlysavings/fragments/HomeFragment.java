package com.example.scholarlysavings.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scholarlysavings.HomeAdapter;
import com.example.scholarlysavings.ProfileAdapter;
import com.example.scholarlysavings.R;
import com.example.scholarlysavings.UserInfo;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
/*
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
*/
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

 //   BarChart barChart;
    public static final String TAG = "HomeFragment";
    private RecyclerView rvHome;
    private HomeAdapter adapter;
    private List<UserInfo> allinfo;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
        barChart = (BarChart) view.findViewById(R.id.barChart);

        ArrayList<BarEntry> bars = new ArrayList<>();
        bars.add(new BarEntry(1, 2));
        bars.add(new BarEntry(2,5));
         */

        rvHome = view.findViewById(R.id.rvHome);

        allinfo = new ArrayList<>();
        adapter = new HomeAdapter(getContext(), allinfo);

        rvHome.setAdapter(adapter);
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        queryHome();
    }

    private void queryHome() {
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