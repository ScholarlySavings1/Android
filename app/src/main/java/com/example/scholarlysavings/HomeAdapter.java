package com.example.scholarlysavings;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{


    private Context context;
    private List<UserInfo> info;

    public HomeAdapter(Context context, List<UserInfo> info) {

        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserInfo userInfo = info.get(position);
        holder.bind(userInfo);

    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView collegeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            collegeName = itemView.findViewById(R.id.schoolName);

            BarChart barChart = itemView.findViewById(R.id.bargraph);

            ArrayList<BarEntry> entries = new ArrayList<>();
            entries.add(new BarEntry(1,4));
            entries.add(new BarEntry(3, 8));

            BarDataSet barDataSet = new BarDataSet(entries, "Income vs Expenses");
            barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
            barDataSet.setValueTextColor(Color.BLACK);
            barDataSet.setValueTextSize(16f);

            BarData barData = new BarData(barDataSet);
            barChart.setData(barData);
            barChart.setFitBars(true);
            barChart.getDescription().setText("Example");
            barChart.animateY(2000);
        }

        public void bind(UserInfo userInfo) {

            collegeName.setText(userInfo.getCollege());
        }
    }
}
