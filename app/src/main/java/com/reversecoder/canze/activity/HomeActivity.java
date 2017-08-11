package com.reversecoder.canze.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.reversecoder.canze.R;
import com.reversecoder.library.storage.SessionManager;
import com.reversecoder.sessiontimeout.engine.activity.SessionTimeoutAppCompatActivity;
import com.reversecoder.sessiontimeout.engine.bearing.SessionTimeoutDialogCallback;
import com.reversecoder.sessiontimeout.engine.injector.SessionTimeoutManager;

import static com.reversecoder.canze.util.AllConstants.IS_USER_LOGGED_IN;

public class HomeActivity extends SessionTimeoutAppCompatActivity {

    RelativeLayout relativeLayoutItemDashboard, relativeLayoutItemMap, relativeLayoutItemSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initHomeUI();
        initHomeAction();
    }

    private void initHomeUI() {
        relativeLayoutItemDashboard = (RelativeLayout) findViewById(R.id.item_dashboard);
        relativeLayoutItemMap = (RelativeLayout) findViewById(R.id.item_map);
        relativeLayoutItemSettings = (RelativeLayout) findViewById(R.id.item_settings);
    }

    private void initHomeAction() {

        SessionTimeoutManager.initSessionTimeoutManager(new SessionTimeoutDialogCallback() {
            @Override
            public void sessionTimeoutButtonClick(DialogInterface dialog) {
                dialog.dismiss();

                doSignOut();
            }
        });
        SessionTimeoutManager.startSessionTimeoutTask(5 * 60 * 1000);

        relativeLayoutItemDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DashBoardActivity.class));
            }
        });

        relativeLayoutItemMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });

        relativeLayoutItemSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
            }
        });
    }

    private void doSignOut() {
        SessionManager.setBooleanSetting(HomeActivity.this, IS_USER_LOGGED_IN, false);
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
