package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
private CheckBox mBtnCheck1;
private CheckBox mBtnCheck2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mBtnCheck1=findViewById(R.id.checkbox4);
        mBtnCheck2=findViewById(R.id.checkbox5);
        mBtnCheck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"4选中":"4未选中",Toast.LENGTH_SHORT).show();
            }
        });
        mBtnCheck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"5选中":"5未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
