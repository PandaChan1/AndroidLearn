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
    private Button mBtnLinear_rv;
    private Button mBthGrid_rv;
    private Button mBtnPu_Rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear=findViewById(R.id.btn_linear);
        mBtnLinear_rv=findViewById(R.id.btn_linear_rv);
        mBthGrid_rv=findViewById(R.id.btn_Grid_rv);
        mBtnPu_Rv=findViewById(R.id.btn_pubu_Rv);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recyclerViewActivity.this,LinearActivity.class);
                startActivity(intent);
            }
        });
        mBtnLinear_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recyclerViewActivity.this,HorizonRvActivity.class);
                startActivity(intent);
            }
        });
        mBthGrid_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recyclerViewActivity.this,GridRvActivity.class);
                startActivity(intent);
            }
        });
        mBtnPu_Rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recyclerViewActivity.this,pubuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
