package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myfirstapp.util.ToastUtil;

public class ProgessActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private Button mBtnPbstart, mBtnProgessDialog1, mBtnProgessDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progess);
        mPb3 = findViewById(R.id.pb_3);
        mBtnPbstart = findViewById(R.id.btn_pb_start);
        mBtnProgessDialog1 = findViewById(R.id.btn_progess_dialog1);
        mBtnProgessDialog2 = findViewById(R.id.btn_progess_dialog2);
       /* mBtnPbstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            handler.sendEmptyMessage(0);
            }
        });*/
       mBtnProgessDialog1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ProgressDialog progressDialog=new ProgressDialog(ProgessActivity.this);
               progressDialog.setTitle("提示");
               progressDialog.setMessage("正在加载");
               progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                   @Override
                   public void onCancel(DialogInterface dialog) {
                       ToastUtil.showMsg(ProgessActivity.this,"Cancel");
                   }
               });
               progressDialog.setCancelable(false);
               progressDialog.show();
           }
       });
       mBtnProgessDialog2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ProgressDialog progressDialog=new ProgressDialog(ProgessActivity.this);
               progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL); //设置横向进度条
               progressDialog.setTitle("提示");
               progressDialog.setMessage("正在下载");
               //可以添加按钮 三种 积极 消极 中性
               progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       //设置点击操作
                   }
               });
               progressDialog.show();

           }
       });
        setLinstener();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPb3.getProgress() < 100) {

                handler.postDelayed(runnable, 500); //延迟500毫秒发送一个消息给runable执行
            } else {
                ToastUtil.showMsg(ProgessActivity.this, "加载完成");
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);//runable发送一个空消息给handler
        }
    };

    private void setLinstener() {
        myClick myClick = new myClick();
        mBtnPbstart.setOnClickListener(myClick);
    }

    private class myClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_pb_start:
                    handler.sendEmptyMessage(0);
                    break;

            }
        }
    }
}
