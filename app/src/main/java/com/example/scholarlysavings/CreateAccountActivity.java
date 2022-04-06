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

        Emailtv = findViewById(R.id.Usernametv);
        Passwordtv = findViewById(R.id.Passwordtv);
        Confirmtv = findViewById(R.id.Confirmtv);
        Createbtn = findViewById(R.id.Createbtn);

        Createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Emailtv.getText().toString();
                String password = Passwordtv.getText().toString();


                newUser(username, password);
            }
        });
    }

    private void newUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setPassword(password);
        user.setUsername(username);
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.e(TAG, "Issue with Login", e);
                }
            }
        });
        goQuestionnaire();
    }

    private void goQuestionnaire() {
        Intent i = new Intent(this, QuestionnaireActivity.class);
        startActivity(i);
        finish();
    }
}