package com.example.myfirstapp.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myfirstapp.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {
    private AFragment aFragment;
    private TextView mTvtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvtitle=findViewById(R.id.tv_title);
        //实例化aFragment
        aFragment=AFragment.newInstance("我是参数");
        //把aFragment添加到Activity中,记得调用commit
       getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }
    public void setData(String title){
        mTvtitle.setText(title);
    }

    @Override
    public void onClick(String test) {
        mTvtitle.setText(test);
    }
}
