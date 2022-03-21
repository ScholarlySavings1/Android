package com.example.scholarlysavings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

@ParseClassName("User")

public class CreateAccountActivity extends AppCompatActivity {

    public static final String TAG = "CreateAccount";
    EditText Emailtv;
    EditText Passwordtv;
    EditText Confirmtv;
    Button Createbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Emailtv = findViewById(R.id.Emailtv);
        Passwordtv = findViewById(R.id.Passwordtv);
        Confirmtv = findViewById(R.id.Confirmtv);
        Createbtn = findViewById(R.id.Createbtn);

        Createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Emailtv.getText().toString();
                String password = Passwordtv.getText().toString();
                newUser(email, password);
            }
        });
    }

    private void newUser(String email, String password) {
        ParseUser user = new ParseUser();
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.e(TAG, "Issue with Login", e);
                }
                goLoginActivity();
            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}