package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class Recieve extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String a = intent.getAction();
        if(a.equals("com.example.broadcast_test")){
            Log.d("Check recieve", "broadcast recieved");
            Toast.makeText(context, "Welcome nash", Toast.LENGTH_SHORT).show();
        }
        else if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
            }
        else {
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show();
            }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
