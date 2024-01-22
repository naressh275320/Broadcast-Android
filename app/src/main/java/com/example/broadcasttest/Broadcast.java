package com.example.broadcasttest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Broadcast extends AppCompatActivity {

    BroadcastReceiver reciever = new Recieve();
    Button broadcast;
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcast = findViewById(R.id.broadcast);
        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                broadcastIntent();
            }
        });
    }

    public void broadcastIntent(){
        Log.d("Nash", "sending broadcast");
        Intent i= new Intent();
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        i.setComponent(new ComponentName("com.example.broadcastrecieve", "com.example.broadcastrecieve.recieve"));
        i.setAction("com.example.broadcast_test");
        i.putExtra("data", "Some data");
        sendBroadcast(i);
    }
}