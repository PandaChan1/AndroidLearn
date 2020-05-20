package com.example.myfirstapp.Listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myfirstapp.R;

public class ListviewActivity extends Activity {
    private ListView mLv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mLv1= this.<ListView>findViewById(R.id.Listv_1);
        mLv1.setAdapter(new myListAdapter(ListviewActivity.this));
        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() { //点击事件 position表示点击的位置
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewActivity.this,"点击pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mLv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewActivity.this,"长按pos:"+position,Toast.LENGTH_SHORT).show();
                return true;  //false 表示事件在这里未截止 后续其他的还可以处理
            }
        });
    }
}
