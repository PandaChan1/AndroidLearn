package com.example.myfirstapp.Gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myfirstapp.R;

public class myGridviewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public myGridviewAdapter(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class Viewholder{
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  //每个格子长什么样子
        Viewholder holder=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_grid,null);
            holder=new Viewholder();
            holder.imageView=convertView.findViewById(R.id.iv_grid);
            holder.textView=convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder= (Viewholder) convertView.getTag();
        }
        //赋值
        holder.textView.setText("花");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589955404034&di=c652011d05505f34683d11fc0cfd61eb&imgtype=0&src=http%3A%2F%2Fimg8.zol.com.cn%2Fbbs%2Fupload%2F21794%2F21793582.jpg").into(holder.imageView);
        return convertView;
    }
}
