package com.example.scholarlysavings;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //ParseObject.registerSubclass(Stretches.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4pHGEGbLdPnuEekbANGzx0VQMhKRlAt6Qdst4Lid")
                .clientKey("TJmxVvqAPCGhSSMBueYBnZZ71m4HipOZ4LK6ZY07")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}