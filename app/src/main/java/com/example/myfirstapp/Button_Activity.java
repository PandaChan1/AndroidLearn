package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Button_Activity extends AppCompatActivity {
   private Button mBtn3;
   private TextView mTv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_);
        mBtn3= this.<Button>findViewById(R.id.btn_3);
        /*mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Button_Activity.this,"btn3被点击了",Toast.LENGTH_SHORT).show();
            }
        });*/
        mTv1= this.<TextView>findViewById(R.id.tv_1);
       /* mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Button_Activity.this,"tv1被点击了",Toast.LENGTH_SHORT).show();
            }
        });*/
       setListener();
    }

    public void showToast(View view){
        Toast.makeText(this,"我被点击了",Toast.LENGTH_SHORT).show();
    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_3:
                    mBtn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(Button_Activity.this,"btn3被点击了",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.tv_1:
                    mTv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(Button_Activity.this,"tv1被点击了",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
            }
        }
    }
    private void setListener(){
        OnClick onClick=new OnClick();
        mTv1.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
    }
}
