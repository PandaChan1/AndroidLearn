package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private Button mBtn_login;
    private TextView username;
    private Button radiobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mBtn_login=findViewById(R.id.login_btn);
        mBtn_login.setOnClickListener(new View.OnClickListener() { //点击事件
            @Override
            public void onClick(View v) {
                Toast.makeText(EditActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(EditActivity.this,TextActivity.class);
                startActivity(intent);
            }
        });
        username=findViewById(R.id.edit_1);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
