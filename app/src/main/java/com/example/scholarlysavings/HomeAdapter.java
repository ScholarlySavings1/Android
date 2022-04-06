package com.example.scholarlysavings;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


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
        }

        public void bind(UserInfo userInfo) {

            collegeName.setText(userInfo.getCollege());
        }
    }
}
