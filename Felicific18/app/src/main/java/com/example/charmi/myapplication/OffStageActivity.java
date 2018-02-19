package com.example.charmi.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.charmi.myapplication.model.OffStageDataItem;
import com.example.charmi.myapplication.services.OffStageService;
import com.example.charmi.myapplication.utils.NetworkHelper;


public class OffStageActivity extends AppCompatActivity {

    private static final String TAG = "OffStageActivity";
    
    private static final String JSON_URL =
            "https://api.myjson.com/bins/1660o9";

    private boolean networkOk;
    TextView output;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: Inside");
//            String message =
//                    intent.getStringExtra(OffStageService.MY_SERVICE_PAYLOAD);
//            Toast.makeText(context, "IN RECIEVE", Toast.LENGTH_SHORT).show();
            OffStageDataItem[] offStageDataItems = (OffStageDataItem[]) intent.getParcelableArrayExtra(OffStageService.MY_SERVICE_PAYLOAD);
            output.setText("");
            for(OffStageDataItem item : offStageDataItems) {
                output.append(item.getEventname() + "\n");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offstage);

        output = (TextView) findViewById(R.id.output);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(OffStageService.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);
        output.append("Network ok: " + networkOk);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }

    public void runClickHandler(View view) {

        if (networkOk) {
            Toast.makeText(this, "Network "+ networkOk + ", Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(OffStageActivity.this, OffStageService.class);
            intent.setData(Uri.parse(JSON_URL));
            startService(intent);
            Log.d(TAG, "runClickHandler: intent doesn't starts");
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }
}
