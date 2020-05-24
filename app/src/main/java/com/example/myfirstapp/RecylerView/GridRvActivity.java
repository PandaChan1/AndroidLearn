package com.example.myfirstapp.RecylerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myfirstapp.R;

public class GridRvActivity extends AppCompatActivity {
private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_rv);
        mRvGrid=findViewById(R.id.grid_rv);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRvActivity.this,3));
        mRvGrid.setAdapter(new GridAdapter(GridRvActivity.this, new GridAdapter.OnItemClickLinstener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRvActivity.this, "click+"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
