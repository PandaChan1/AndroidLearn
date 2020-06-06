package com.example.myfirstapp.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class sharedpreferencesActivity extends AppCompatActivity {
    private Button mBtnshow,mBtnsave;
    private TextView mTvshare;
    private EditText mEtcontent;
    private SharedPreferences mSharedpreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        mBtnsave=findViewById(R.id.btn_save);
        mBtnshow=findViewById(R.id.btn_show);
        mEtcontent=findViewById(R.id.et_content);
        mTvshare=findViewById(R.id.tv_share);
        mSharedpreferences=this.getSharedPreferences("data",MODE_PRIVATE); //MODE_PRIVATE表示 文件只有当前本应用可以读写
        mEditor=mSharedpreferences.edit();

        mBtnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name",mEtcontent.getText().toString());
                mEditor.apply();

            }
        });

        mBtnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvshare.setText(mSharedpreferences.getString("name",""));

            }
        });
    }
}
