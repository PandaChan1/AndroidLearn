package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtntoast_1,mBtntoast_2,mBtntoast_3,mBtntoast_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtntoast_1=findViewById(R.id.Toast_1);
        mBtntoast_2=findViewById(R.id.Toast_2);
        mBtntoast_3=findViewById(R.id.Toast_3);
        mBtntoast_4=findViewById(R.id.Toast_4);
        onClick onclick=new onClick();
        mBtntoast_1.setOnClickListener(onclick);
        mBtntoast_2.setOnClickListener(onclick);
        mBtntoast_3.setOnClickListener(onclick);
        mBtntoast_4.setOnClickListener(onclick);
    }
    class onClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.Toast_1:
                    Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG).show();
                    break;
                case R.id.Toast_2:
                    Toast toastcenter=Toast.makeText(getApplicationContext(),"居中Toast",Toast.LENGTH_LONG);
                    toastcenter.setGravity(Gravity.CENTER,0,0);
                    toastcenter.show();
                    break;
                case R.id.Toast_3:
                    Toast toastCustom =new Toast(getApplicationContext());
                    LayoutInflater inflater=LayoutInflater.from(ToastActivity.this);
                    View view=inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView=view.findViewById(R.id.iv_toast);
                    TextView textView=view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.plants_1);
                    textView.setText("自定义Toast带图片");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.Toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"简单封装");
                    break;
            }
        }
    }
}
