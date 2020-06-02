package com.example.myfirstapp.jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;
import com.example.myfirstapp.util.ToastUtil;

public class BActivity extends AppCompatActivity {
    private TextView mTvtitle;
    private Button mBtnFinish;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mTvtitle=findViewById(R.id.tv_title_jump);
        mBtnFinish=findViewById(R.id.btn_finish);
        final Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int number=bundle.getInt("number");
        mTvtitle.setText(name+","+number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle.putString("mesg","我回来了!");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });


    }

}
