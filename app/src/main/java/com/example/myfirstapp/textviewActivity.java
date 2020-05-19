package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class textviewActivity extends AppCompatActivity {
    private TextView mTv4,mTv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        mTv4= this.<TextView>findViewById(R.id.testview_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mTv4.getPaint().setAntiAlias(true);
        mTv5= this.<TextView>findViewById(R.id.testview_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}

