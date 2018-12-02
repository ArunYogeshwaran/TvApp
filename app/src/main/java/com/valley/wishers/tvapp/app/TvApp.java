package com.valley.wishers.tvapp.app;

import android.app.Application;
import android.content.Context;

public class TvApp extends Application {
    private static TvApp context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = (TvApp) getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
