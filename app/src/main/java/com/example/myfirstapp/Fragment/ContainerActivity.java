package com.example.myfirstapp.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myfirstapp.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    private BFragment bFragment;
    private Button mBtnchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mBtnchange=findViewById(R.id.btn_change);
        mBtnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment==null){
                    bFragment=new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
            }
        });
        //实例化aFragment
        aFragment=new AFragment();
        //把aFragment添加到Activity中,记得调用commit
       getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();
    }
}
