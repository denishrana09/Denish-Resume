package com.example.charmi.myapplication.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


import com.example.charmi.myapplication.model.OffStageDataItem;
import com.example.charmi.myapplication.utils.HttpHelper;
import com.google.gson.Gson;

import java.io.IOException;


public class OffStageService extends IntentService {

    public static final String TAG = "OffStageService";
    public static final String MY_SERVICE_MESSAGE = "myServiceMessage";
    public static final String MY_SERVICE_PAYLOAD = "myServicePayload";

    public OffStageService() {
        super("OffStageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: starts");
        Uri uri = intent.getData();
        Log.e(TAG, "onHandleIntent: " + uri.toString());

        String response;
        try {
            response = HttpHelper.downloadUrl(uri.toString());
            Log.d(TAG, "onHandleIntent: response is "+ response);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Gson gson = new Gson();
        OffStageDataItem[] offStageDataItems = gson.fromJson(response,OffStageDataItem[].class);


        Log.d(TAG, "onHandleIntent: running");
        Intent messageIntent = new Intent(MY_SERVICE_MESSAGE);
        messageIntent.putExtra(MY_SERVICE_PAYLOAD, offStageDataItems);
        LocalBroadcastManager manager =
                LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

}
