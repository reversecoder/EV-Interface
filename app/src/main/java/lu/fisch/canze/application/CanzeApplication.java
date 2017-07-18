package lu.fisch.canze.application;

import android.app.Application;

import com.reversecoder.logger.LogType;
import com.reversecoder.logger.Logger;

import lu.fisch.canze.BuildConfig;

public class CanzeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.Builder.getInstance(this)
                .isLoggable(BuildConfig.DEBUG)
                .logType(LogType.DEBUG)
//                .tag("MyTag")
                .build();
    }
}
