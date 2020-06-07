package com.example.myfirstapp.Broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class BroadcastActivity extends AppCompatActivity {
    private Button mBtn1;
    private TextView mTvtest;
    private MyBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        mBtn1=findViewById(R.id.btn1);
        mTvtest=findViewById(R.id.tv_test1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BroadcastActivity.this,BroadcastActivity2.class);
                startActivity(intent);
            }
        });
        mBroadcast=new MyBroadcast();
        IntentFilter intentFilter=new IntentFilter();  //过滤筛选我要接受的广播
        intentFilter.addAction("com.example.update");
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcast,intentFilter); //注册广播

    }
    private class MyBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.example.update":
                    mTvtest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcast);
    }
}
