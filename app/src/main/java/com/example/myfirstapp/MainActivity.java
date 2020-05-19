package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnRadio;
    private Button mBtnCheckB;
    private Button mBtnlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView= (Button) findViewById(R.id.butt_1);
        /*mBtnTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //跳转到新的页面
                Intent intent=new Intent(MainActivity.this,textviewActivity.class);
                startActivity(intent);
            }
        });*/
        mBtnButton= this.<Button>findViewById(R.id.btn_button);
        /*mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到button演示界面
                Intent intent=new Intent(MainActivity.this,Button_Activity.class);
                startActivity(intent);
            }
        });*/
        mBtnRadio=findViewById(R.id.RadioBtn);
        mBtnCheckB=findViewById(R.id.check_box_1);
        mBtnlog=findViewById(R.id.btn_log);
        setLinstener();
    }
    private void setLinstener(){
        click cl=new click();
        mBtnButton.setOnClickListener(cl);
        mBtnTextView.setOnClickListener(cl);
        mBtnRadio.setOnClickListener(cl);
        mBtnCheckB.setOnClickListener(cl);
        mBtnlog.setOnClickListener(cl);
    }
    private class click implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.butt_1:
                    intent=new Intent(MainActivity.this,textviewActivity.class);
                    break;
                case R.id.btn_button:
                    intent=new Intent(MainActivity.this,Button_Activity.class);
                    break;
                case R.id.RadioBtn:
                    intent=new Intent(MainActivity.this,RadioActivity.class);
                    break;
                case R.id.check_box_1:
                    intent=new Intent(MainActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_log:
                    intent=new Intent(MainActivity.this,EditActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
