package com.example.alarmmanagerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {

    private String TAG = "AlarmBro";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"On Receive");
      if(intent.getStringExtra("Alarm").equals("Start Alarm"))
      {
          Log.d(TAG,"On Receive Start Alarm");
          //just for checking timer
         /* DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Calendar cal = Calendar.getInstance();
          String timerString = dateFormat.format(cal.getTime());*/
          //Log.d("Alarm","Current: "+timerString);
      }else if(intent.getStringExtra("Alarm").equals("Stop Alarm"))
      {
          Log.d(TAG,"On Receive Stop Alarm");
      }

    }
}
