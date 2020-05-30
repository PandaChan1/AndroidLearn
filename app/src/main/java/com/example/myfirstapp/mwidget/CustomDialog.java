package com.example.myfirstapp.mwidget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myfirstapp.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvtitle,mTvmesg,mTvcancel,mTvconfirm;

    private String title,mesg,cancel,confirm;

    private IOnCancelLinstener onCancelLinstener;

    private  IOnConfirmLinstener onConfirmLinstener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context,int themeId) {
        super(context,themeId);
    }
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMesg(String mesg) {
        this.mesg = mesg;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelLinstener linstener) {
        this.cancel = cancel;
        this.onCancelLinstener=linstener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmLinstener linstener) {
        this.confirm = confirm;
        this.onConfirmLinstener=linstener;
        return this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);


        //设置宽度  固定写法
        WindowManager manager=getWindow().getWindowManager();
        Display display=manager.getDefaultDisplay();
        WindowManager.LayoutParams p=getWindow().getAttributes();
        Point size=new Point();
        display.getSize(size);
        p.width=(int)(size.x*0.8);  //设置Dialog宽度为屏幕的80%
        getWindow().setAttributes(p);



        mTvtitle=findViewById(R.id.tv_title);
        mTvmesg=findViewById(R.id.tv_mesg);
        mTvcancel=findViewById(R.id.tv_cancel);
        mTvconfirm=findViewById(R.id.tv_confirm);
        if (TextUtils.isEmpty(title)) {
            mTvtitle.setText(title);
        }
        if (TextUtils.isEmpty(mesg)){
            mTvmesg.setText(mesg);
        }
        if (TextUtils.isEmpty(cancel)){
            mTvcancel.setText(cancel);
        }
        if (TextUtils.isEmpty(confirm)){
            mTvconfirm.setText(confirm);
        }
        mTvcancel.setOnClickListener(this);
        mTvconfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                if (onCancelLinstener!=null){
                    onCancelLinstener.OnCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if (onConfirmLinstener!=null){
                    onConfirmLinstener.OnConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelLinstener{
        void OnCancel(CustomDialog dialog);
    }
    public interface  IOnConfirmLinstener{
        void OnConfirm(CustomDialog dialog);
    }
}
