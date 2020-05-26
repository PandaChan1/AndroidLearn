package com.example.myfirstapp.RecylerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfirstapp.R;

public class pubuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRv_pubu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubu_recycler_view);
        mRv_pubu=findViewById(R.id.rv_pubu);
        mRv_pubu.addItemDecoration(new MyDecoration());
        mRv_pubu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)); //垂直表示多少列
        mRv_pubu.setAdapter(new pubuAdapter(pubuRecyclerViewActivity.this, new pubuAdapter.OnItemClickLinstener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(pubuRecyclerViewActivity.this,"click:"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyDecoration extends  RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap=getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(gap,gap,gap,gap);
        }
    }
}
