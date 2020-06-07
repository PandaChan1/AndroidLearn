package com.example.myfirstapp.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.R;

public class AnimeActivity extends AppCompatActivity {
    private Button mBtnanime1,mBtnanime2,mBtnanime3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        mBtnanime1=findViewById(R.id.anime1);
        mBtnanime2=findViewById(R.id.anime2);
        mBtnanime3=findViewById(R.id.anime3);
        setlinstener();

    }

    private void setlinstener(){
        onclick cl=new onclick();
        mBtnanime1.setOnClickListener(cl);
        mBtnanime2.setOnClickListener(cl);
        mBtnanime3.setOnClickListener(cl);
    }

    private class onclick implements View.OnClickListener{
        Intent intent=null;

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.anime1:
                    intent=new Intent(AnimeActivity.this,Object_animActivity.class);
                    break;
                case R.id.anime2:
                    break;
                case R.id.anime3:
                    break;
            }
            startActivity(intent);
        }
    }
}
