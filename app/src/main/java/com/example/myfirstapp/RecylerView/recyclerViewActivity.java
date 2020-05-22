package com.example.myfirstapp.RecylerView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myfirstapp.Listview.ListviewActivity;
import com.example.myfirstapp.R;

public class recyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear=findViewById(R.id.btn_linear);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recyclerViewActivity.this,LinearActivity.class);
                startActivity(intent);
            }
        });
    }
}
