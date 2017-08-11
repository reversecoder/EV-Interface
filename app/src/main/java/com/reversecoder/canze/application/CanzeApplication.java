package com.reversecoder.canze.application;

import android.app.Application;

import com.reversecoder.logger.LogType;
import com.reversecoder.logger.Logger;

import com.reversecoder.canze.BuildConfig;
import com.reversecoder.sqlite.LitePal;

public class CanzeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(this);

        Logger.Builder.getInstance(this)
                .isLoggable(BuildConfig.DEBUG)
                .logType(LogType.DEBUG)
//                .tag("MyTag")
                .build();
    }
}
