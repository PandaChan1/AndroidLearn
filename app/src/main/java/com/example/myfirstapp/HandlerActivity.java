package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.myfirstapp.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {

    private Handler mhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
//        mhandler=new android.os.Handler();
//        mhandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(HandlerActivity.this,Button_Activity.class);
//                startActivity(intent);
//            }
//        }, 3000);
        mhandler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this,"线程通信成功");
                        break;
                }

            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message=new Message();
                message.what=1;
                mhandler.sendMessage(message);
            }
        }.start();
    }
}
