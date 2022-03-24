package com.example.scholarlysavings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Context context;
    private List<UserInfo> info;

    public ProfileAdapter(Context context, List<UserInfo> info){
        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false);
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

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMobilePhone;
        private TextView tvName;
        private TextView tvIncome;
        private TextView tvExpenses;
        private ImageView ivProfile;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.displayName);
            tvIncome = itemView.findViewById(R.id.tvIncome);
            tvMobilePhone = itemView.findViewById(R.id.tvMobilePhone);
            tvExpenses = itemView.findViewById(R.id.tvExpenses);
            ivProfile = itemView.findViewById(R.id.ivProfile);
        }

        public void bind(UserInfo userInfo) {
            tvMobilePhone.setText(userInfo.getPhone());
            tvName.setText(userInfo.getName());
            tvIncome.setText(userInfo.getIncome());
            tvExpenses.setText(userInfo.getExpenses());
            ParseFile image = userInfo.getImage();
            if (image != null){
                Glide.with(context).load(image.getUrl()).into(ivProfile);
            }
        }
    }

}
