package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI=findViewById(R.id.btn_ui);
        mBtnevent=findViewById(R.id.btn_event);
        SetListener();

    }
    private void SetListener(){
        OnClick ol=new OnClick();
        mBtnUI.setOnClickListener(ol);
        mBtnevent.setOnClickListener(ol);
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
            }
            startActivity(intent);
        }
    }
}
