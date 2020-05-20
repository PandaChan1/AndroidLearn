package com.example.myfirstapp.Gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class GridviewActivity extends AppCompatActivity {
    private GridView mGridv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGridv1=findViewById(R.id.grid_1);
        mGridv1.setAdapter(new myGridviewAdapter(GridviewActivity.this));
        mGridv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridviewActivity.this,"点击"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mGridv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridviewActivity.this,"长按"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
