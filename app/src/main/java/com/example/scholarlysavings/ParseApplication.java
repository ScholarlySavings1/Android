package com.example.scholarlysavings;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //ParseObject.registerSubclass(User.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4pHGEGbLdPnuEekbANGzx0VQMhKRlAt6Qdst4Lid")
                .clientKey("TJmxVvqAPCGhSSMBueYBnZZ71m4HipOZ4LK6ZY07")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}