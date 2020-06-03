package com.example.myfirstapp.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
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
    private Button mBtnjumptoa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d("BActivity","---onCreate---");
        Log.d("BActivity","taskid:"+getTaskId()+"   hash:"+hashCode());
        logTaskname();
        mTvtitle=findViewById(R.id.tv_title_jump);
        mBtnjumptoa=findViewById(R.id.btn_jumptoa);
        mBtnFinish=findViewById(R.id.btn_finish);
        final Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int number=bundle.getInt("number");
        mTvtitle.setText(name+","+number);

        mBtnjumptoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle1.putString("mesg","我回来了!");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity","---onNewIntent---");
        Log.d("BActivity","taskid:"+getTaskId()+"   hash:"+hashCode());
        logTaskname();
    }

    private void logTaskname(){
        try {
            ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
