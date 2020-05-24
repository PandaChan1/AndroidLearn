package com.example.myfirstapp.RecylerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfirstapp.R;

public class HorizonRvActivity extends AppCompatActivity {
    private RecyclerView mRvhori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizon_rv);
        mRvhori=findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HorizonRvActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRvhori.setLayoutManager(linearLayoutManager);
        mRvhori.addItemDecoration(new MyDecorationHori());
        mRvhori.setAdapter(new HoriAdapter(HorizonRvActivity.this, new HoriAdapter.OnItemClickLinstener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizonRvActivity.this, "click"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyDecorationHori extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
