package com.example.scholarlysavings;

import static android.app.Activity.RESULT_OK;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.io.File;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    public static final String TAG = "ProfileAdapter";
    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 42;
    private File photoFile;
    public String photoFileName = "photo.jpg";
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
        private TextView tvEmail;
        public TextView tvPassword;
        private Button btnLogout;
        private Button btnChange;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.Usernametv);
            tvIncome = itemView.findViewById(R.id.tvIncome);
            tvMobilePhone = itemView.findViewById(R.id.tvMobilePhone);
            tvExpenses = itemView.findViewById(R.id.tvExpenses);
            ivProfile = itemView.findViewById(R.id.ivProfile);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPassword = itemView.findViewById(R.id.tvPassword);
            btnLogout = itemView.findViewById(R.id.btnLogout);
            btnChange = itemView.findViewById(R.id.btnChange);

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goLoginActivity();
                }
            });

            btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //launchCamera();
                }
            });
        }

        private void goLoginActivity() {
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
        }

        public void bind(UserInfo userInfo) {
            tvMobilePhone.setText("Mobile Phone Number: " + userInfo.getPhone());
            tvName.setText(userInfo.getUser().getUsername());
            tvIncome.setText("Income: " + userInfo.getIncome());
            tvExpenses.setText("Expenses: " + userInfo.getExpenses());
            tvEmail.setText("Email: " + userInfo.getEmail());
           // tvPassword.setText("Password: " + userInfo.getUser().getPassword());
            ParseFile image = userInfo.getImage();
            if (image != null){
                Glide.with(context).load(image.getUrl()).into(ivProfile);
            }
        }
    }

}
