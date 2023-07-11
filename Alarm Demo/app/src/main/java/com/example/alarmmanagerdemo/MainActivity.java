package com.example.alarmmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainBro";
    private Button startAlarmBtn;
    private Button stopAlarmBtn;
    private EditText timeEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAlarmBtn = findViewById(R.id.startAlarmBtn);
        stopAlarmBtn = findViewById(R.id.stopAlarmBtn);
        timeEt = findViewById(R.id.timeEt);
        batteryOpt();

        startAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlarm();
            }
        });

        stopAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }

    private void startAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("Alarm","Start Alarm");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000,pendingIntent);
        //set Exact
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                alarmTime(), pendingIntent);
    }

    private long alarmTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,Integer.parseInt(timeEt.getText().toString().trim()));
        return calendar.getTimeInMillis();
    }

    private long timeInMillis()
    {
        //Specifying the pattern of input date and time
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateString = "12-02-2021"+" "+timeEt.getText();
        Date date = null;
        try{
            //formatting the dateString to convert it into a Date
             date = sdf.parse(dateString);
            System.out.println("Given Time in milliseconds : "+date.getTime());

          /*  Calendar calendar = Calendar.getInstance();
            //Setting the Calendar date and time to the given date and time
            calendar.setTime(date);
            System.out.println("Given Time in milliseconds : "+calendar.getTimeInMillis());*/
        }catch(ParseException e){
            e.printStackTrace();
        }

        return date.getTime();
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("Alarm","Stop Alarm");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);

     }

    private void batteryOpt(){
        Intent intent = new Intent();
        String packageName =getPackageName();
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (pm.isIgnoringBatteryOptimizations(packageName)){
                Log.d(TAG,"Ignoring Battery Optimization");
                //intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
            }
            else {
                Log.d(TAG,"Not Ignoring Battery Optimization");
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);
            }
        }
        //startActivity(intent);
    }

}