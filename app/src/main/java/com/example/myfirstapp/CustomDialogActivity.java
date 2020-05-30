package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.mwidget.CustomDialog;
import com.example.myfirstapp.util.ToastUtil;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mBtnCustondia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnCustondia=findViewById(R.id.btn_customDialog);
        mBtnCustondia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMesg("确认删除此项？")
                        .setCancel("取消", new CustomDialog.IOnCancelLinstener() {
                            @Override
                            public void OnCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"Cancel...");
                            }
                        })
                        .setConfirm("确认", new CustomDialog.IOnConfirmLinstener() {
                            @Override
                            public void OnConfirm(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"Confirm...");
                            }
                        }).show();
            }
        });
    }
}
