package com.mechat.xteam.android_project_2;

import android.app.Application;
import android.content.Context;
import android.util.Log;


public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }

    public static void log(String title, String content) {
        Log.e(title, content);
    }
}