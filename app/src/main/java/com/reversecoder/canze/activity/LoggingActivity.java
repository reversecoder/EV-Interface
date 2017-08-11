package com.reversecoder.canze.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.reversecoder.logger.Logger;

import com.reversecoder.canze.R;
import com.reversecoder.canze.actors.Field;
import com.reversecoder.canze.actors.Fields;
import com.reversecoder.canze.adapters.FieldAdapter;
import com.reversecoder.canze.classes.LoggingLogger;

public class LoggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        Logger.d("LoggingActivity: onCreate");

        // load logging logger
        LoggingLogger.getInstance();
        updateList();

        ArrayAdapter arrayAdapter;

        final Spinner field = (Spinner) findViewById(R.id.field);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        arrayAdapter.add(Fields.getInstance().getBySID("5d7.0"));       // speed
        arrayAdapter.add(Fields.getInstance().getBySID("1fd.48"));      // power
        field.setAdapter(arrayAdapter);

        final Spinner interval = (Spinner) findViewById(R.id.interval);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        for(int i = 5; i<30; i+=5)
            arrayAdapter.add(i+" s");
        for(int i = 30; i<=120; i+=30)
            arrayAdapter.add(i+" s");
        interval.setAdapter(arrayAdapter);

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoggingLogger loggingLogger = LoggingLogger.getInstance();

                String intervalString = interval.getSelectedItem().toString();
                intervalString=intervalString.replace(" s","");
                int interval = Integer.valueOf(intervalString);

                // add to logger
                loggingLogger.add((Field) field.getSelectedItem(),interval);
                updateList();
            }
        });
    }


    private void updateList()
    {
        ListView listView = (ListView) findViewById(R.id.selectedFieldsList);
        FieldAdapter fieldAdapter = new FieldAdapter(DashBoardActivity.getInstance() ,R.layout.logger_field, LoggingLogger.getInstance().getLoggingFields());
        listView.setAdapter(fieldAdapter);

        /*
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        LoggingLogger loggingLogger = LoggingLogger.getInstance();
        DashBoardActivity.debug("Logger: actual fields in list = "+loggingLogger.size());
        for(int i=0; i<loggingLogger.size(); i++) {
            arrayAdapter.add(loggingLogger.getField(i)+"\n"+loggingLogger.getIntnerval(i)+" s");
        }
        listView.setAdapter(arrayAdapter);
        */
    }

}
