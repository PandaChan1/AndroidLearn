package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.myfirstapp.util.ToastUtil;

public class PopUpActivity extends AppCompatActivity {
    private Button mBtnpop;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        mBtnpop=findViewById(R.id.btn_pop);
        mBtnpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.layout_pop,null);
                TextView textView=view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPop.dismiss();
                        //do something...
                        ToastUtil.showMsg(PopUpActivity.this,"好");
                    }
                });
                mPop=new PopupWindow(view,mBtnpop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true); //设置点击外面取消
                mPop.setFocusable(true); //点击按钮之后先取消 再点击才出现
                mPop.showAsDropDown(mBtnpop);


            }
        });
    }
}
