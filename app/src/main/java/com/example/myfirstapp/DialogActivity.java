package com.example.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mDialog1,mDialog2,mDialog3,mDialog4,mDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mDialog1=findViewById(R.id.btn_dialog_1);
        mDialog2=findViewById(R.id.btn_dialog_2);
        mDialog3=findViewById(R.id.btn_dialog_3);
        mDialog4=findViewById(R.id.btn_dialog_4);
        mDialog5=findViewById(R.id.btn_dialog_5);
        onclick onclick=new onclick();
        mDialog1.setOnClickListener(onclick);
        mDialog2.setOnClickListener(onclick);
        mDialog3.setOnClickListener(onclick);
        mDialog4.setOnClickListener(onclick);
        mDialog5.setOnClickListener(onclick);
    }
    private class onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_dialog_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得课程如何？")
                            .setIcon(R.drawable.apple_1)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this,"你很诚实");
                                }
                            }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"你再瞅瞅");
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"睁眼说瞎话");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_2:
                    final String [] array2=new String[]{"男","女"};
                    AlertDialog.Builder builder2=new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_3:
                    final String [] array3=new String[]{"男","女"};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() { //0 指默认选择的数组中顺序
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array3[which]);
                            dialog.dismiss();  //选择后弹窗自动消失
                        }
                    }).setCancelable(false) // 点弹窗以外区域弹窗不会消耗  默认是true
                            .show();
                    break;
                case R.id.btn_dialog_4:
                    final String [] array4=new String[]{"唱歌","跳舞","打篮球","Rap"};
                    boolean[] isSelected =new boolean[]{false,false,false,true};
                    AlertDialog.Builder builder4=new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which]+": "+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view=LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText etusername=view.findViewById(R.id.et_username);
                    EditText etpassword=view.findViewById(R.id.et_password);
                    Button btnlogin=view.findViewById(R.id.btn_dialog_login);
                    btnlogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //
                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }
}
