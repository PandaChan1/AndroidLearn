package com.example.myfirstapp.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.R;

public class MDatastorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnsharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_datastorage);
        mBtnsharedpreferences=findViewById(R.id.btn_sharedpreferences);
        mBtnsharedpreferences.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch(v.getId()) {
            case R.id.btn_sharedpreferences:
                intent=new Intent(MDatastorageActivity.this,sharedpreferencesActivity.class);
                break;
        }
        startActivity(intent);
    }
}
