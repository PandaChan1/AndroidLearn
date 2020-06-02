package com.example.myfirstapp.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class AActivity extends AppCompatActivity {
    private Button mBtnjumptob;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnjumptob=findViewById(R.id.btn_jumptob);
        mBtnjumptob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent=new Intent(AActivity.this,BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","PandaChan1");
                bundle.putInt("number",233);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,0);  //0是为了区分，不止一个按钮调用startActivityForResult，分辨返回的数据属于谁
                //显式跳转2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);
                //显式跳转3
//                Intent intent=new Intent();
//                intent.setClassName(AActivity.this,"com.example.myfirstapp.jump.BActivity");
//                startActivity(intent);
                //显式跳转4
//                Intent intent=new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.myfirstapp.jump.BActivity"));
//                startActivity(intent);
                //隐式1
//                Intent intent=new Intent();
//                intent.setAction("com.example.test.BActivity");  //AndroidMainifest.xml中随便写写的BActivity的action属性
//                startActivity(intent);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("mesg"),Toast.LENGTH_LONG).show();
    }
}
