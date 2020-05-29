package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.Gridview.GridviewActivity;
import com.example.myfirstapp.Listview.ListviewActivity;
import com.example.myfirstapp.RecylerView.recyclerViewActivity;
import com.example.myfirstapp.webView.webViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnRadio;
    private Button mBtnCheckB;
    private Button mBtnlog;
    private Button mBtnimageview;
    private Button mBtnlistview;
    private Button mBtnGridview;
    private Button mBtnRV1;
    private Button mBtnwebv;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
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
        mBtnimageview=findViewById(R.id.btn_Imagev);
        mBtnlistview=findViewById(R.id.btn_listv);
        mBtnGridview=findViewById(R.id.btn_grid);
        mBtnRV1=findViewById(R.id.btn_rv);
        mBtnwebv=findViewById(R.id.btn_webv);
        mBtnToast=findViewById(R.id.btn_Toast);
        mBtnDialog=findViewById(R.id.btn_dialog);
        mBtnProgess=findViewById(R.id.btn_progess);

        setLinstener();
    }
    private void setLinstener(){
        click cl=new click();
        mBtnButton.setOnClickListener(cl);
        mBtnTextView.setOnClickListener(cl);
        mBtnRadio.setOnClickListener(cl);
        mBtnCheckB.setOnClickListener(cl);
        mBtnlog.setOnClickListener(cl);
        mBtnimageview.setOnClickListener(cl);
        mBtnlistview.setOnClickListener(cl);
        mBtnGridview.setOnClickListener(cl);
        mBtnRV1.setOnClickListener(cl);
        mBtnwebv.setOnClickListener(cl);
        mBtnToast.setOnClickListener(cl);
        mBtnDialog.setOnClickListener(cl);
        mBtnProgess.setOnClickListener(cl);
    }
    private class click implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.butt_1:
                    intent=new Intent(UIActivity.this,textviewActivity.class);
                    break;
                case R.id.btn_button:
                    intent=new Intent(UIActivity.this,Button_Activity.class);
                    break;
                case R.id.RadioBtn:
                    intent=new Intent(UIActivity.this,RadioActivity.class);
                    break;
                case R.id.check_box_1:
                    intent=new Intent(UIActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_log:
                    intent=new Intent(UIActivity.this,EditActivity.class);
                    break;
                case R.id.btn_Imagev:
                    intent=new Intent(UIActivity.this,Imageview_Activity.class);
                    break;
                case R.id.btn_listv:
                    intent=new Intent(UIActivity.this, ListviewActivity.class);
                    break;
                case R.id.btn_grid:
                    intent=new Intent(UIActivity.this, GridviewActivity.class);
                    break;
                case R.id.btn_rv:
                    intent=new Intent(UIActivity.this, recyclerViewActivity.class);
                    break;
                case R.id.btn_webv:
                    intent=new Intent(UIActivity.this, webViewActivity.class);
                    break;
                case R.id.btn_Toast:
                    intent=new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent=new Intent(UIActivity.this,DialogActivity.class);
                    break;
                case R.id.btn_progess:
                    intent=new Intent(UIActivity.this,ProgessActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
