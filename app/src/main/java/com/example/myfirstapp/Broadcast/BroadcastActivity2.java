package com.example.myfirstapp.Broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.R;
import com.example.myfirstapp.util.ToastUtil;

public class BroadcastActivity2 extends AppCompatActivity {
    private Button mBtnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast2);
        mBtnclick=findViewById(R.id.btn_click);
        mBtnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.update");
                LocalBroadcastManager.getInstance(BroadcastActivity2.this).sendBroadcast(intent);
                ToastUtil.showMsg(BroadcastActivity2.this,"发送广播成功");
            }
        });
    }
}
