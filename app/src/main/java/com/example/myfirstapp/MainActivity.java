package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.DataStorage.MDatastorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnevent;
    private Button mBtnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI=findViewById(R.id.btn_ui);
        mBtnevent=findViewById(R.id.btn_event);
        mBtnData=findViewById(R.id.btn_data);
        SetListener();

    }
    private void SetListener(){
        OnClick ol=new OnClick();
        mBtnUI.setOnClickListener(ol);
        mBtnevent.setOnClickListener(ol);
        mBtnData.setOnClickListener(ol);
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
            }
            startActivity(intent);
        }
    }
}
