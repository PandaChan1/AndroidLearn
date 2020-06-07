package com.example.myfirstapp.anime;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myfirstapp.R;

import org.w3c.dom.Text;

public class Object_animActivity extends AppCompatActivity {
    private TextView mTvanime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        mTvanime=findViewById(R.id.tv_anime);

        //view自带方法实现属性动画
//        mTvanime.animate().translationYBy(500).setDuration(2000).start(); //沿y轴移动500单位  2秒内
//        mTvanime.animate().alpha(0).setDuration(2000).start();//两秒内透明度变为0

//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //valueAnimator实际的值
//                Log.d("aaaa",animation.getAnimatedValue()+"");
//                //动画的进度
//                Log.d("aaaa",animation.getAnimatedFraction()+"");
//            }
//        });
//valueAnimator.start();

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mTvanime,"translationY",0,500,200,800);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}
