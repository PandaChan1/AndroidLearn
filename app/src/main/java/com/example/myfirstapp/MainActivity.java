package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.Broadcast.BroadcastActivity;
import com.example.myfirstapp.DataStorage.MDatastorageActivity;
import com.example.myfirstapp.anime.AnimeActivity;
import com.example.myfirstapp.anime.Object_animActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnevent;
    private Button mBtnData;
    private Button mBtnBroad;
    private Button mBtndonghua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI=findViewById(R.id.btn_ui);
        mBtnevent=findViewById(R.id.btn_event);
        mBtnData=findViewById(R.id.btn_data);
        mBtnBroad=findViewById(R.id.btn_broad);
        mBtndonghua=findViewById(R.id.btn_donghua);
        SetListener();


        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

    }
    private void SetListener(){
        OnClick ol=new OnClick();
        mBtnUI.setOnClickListener(ol);
        mBtnevent.setOnClickListener(ol);
        mBtnData.setOnClickListener(ol);
        mBtnBroad.setOnClickListener(ol);
        mBtndonghua.setOnClickListener(ol);
    }
   private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch(v.getId()){
                case R.id.btn_ui:
                    intent=new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent=new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent=new Intent(MainActivity.this, MDatastorageActivity.class);
                    break;
                case R.id.btn_broad:
                    intent=new Intent(MainActivity.this, BroadcastActivity.class);
                    break;
                case R.id.btn_donghua:
                    intent=new Intent(MainActivity.this, AnimeActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
