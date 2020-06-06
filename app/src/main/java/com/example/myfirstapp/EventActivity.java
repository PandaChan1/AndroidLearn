package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.mwidget.MyButton;
import com.example.myfirstapp.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnclickme;
    private MyButton mBtnmybutton;
    private Button mBtnHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnclickme=findViewById(R.id.btn_clickme);
        mBtnmybutton=findViewById(R.id.btn_mybutton);
        mBtnHandler=findViewById(R.id.btn_handler);
        mBtnmybutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Linstener","---onTouch---");
                        break;
                }
                return false;
            }
        });
       mBtnmybutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d("Linstener","---onClick---");
           }
       });
        //内部类实现
        mBtnclickme.setOnClickListener(new onclick());
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
        //匿名内部类实现
//        mBtnclickme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("匿名内部类","click");
//                ToastUtil.showMsg(EventActivity.this,"匿名内部类click.....");
//            }
//        });
        //通过事件源所在的类实现
//        mBtnclickme.setOnClickListener(EventActivity.this);
        //通过外部类实现------不常用
//        mBtnclickme.setOnClickListener(new MyClickListener(EventActivity.this));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clickme:
                ToastUtil.showMsg(EventActivity.this,"click.....");
                break;
        }
    }

    //内部类监听点击事件
    class onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_clickme:
                    Log.d("内部类","click");
                    ToastUtil.showMsg(EventActivity.this,"内部类click.....");
                    break;
            }
        }
    }
    //布局文件中onClick属性设置监听
    public void show(View view){
        switch(view.getId()){
            case R.id.btn_clickme:
                Log.d("布局文件","click");
                ToastUtil.showMsg(EventActivity.this,"布局文件click.....");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","---onTouchEvent---");
                break;
        }
        return false;
    }
}
