package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnclickme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnclickme=findViewById(R.id.btn_clickme);
        //内部类实现
        mBtnclickme.setOnClickListener(new onclick());
        //匿名内部类实现
        mBtnclickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("匿名内部类","click");
                ToastUtil.showMsg(EventActivity.this,"匿名内部类click.....");
            }
        });
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
}
