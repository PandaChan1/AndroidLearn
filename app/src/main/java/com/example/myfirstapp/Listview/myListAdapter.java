package com.example.myfirstapp.Listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myfirstapp.R;

import org.w3c.dom.Text;

public class myListAdapter extends BaseAdapter {
private  Context mContext;
private LayoutInflater mLayoutInflater;
    public myListAdapter(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() { //列表长度
        return 10; //先固定为10
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
        public TextView tvTitle,tvTime,tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  //列表每一行长什么样子
        Viewholder holder=null;
        if (convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_listview,null);
            holder=new Viewholder();
            holder.imageView= convertView.<ImageView>findViewById(R.id.iv);
            holder.tvTitle= convertView.<TextView>findViewById(R.id.tv_title);
            holder.tvTime= convertView.<TextView>findViewById(R.id.tv_time);
            holder.tvContent= convertView.<TextView>findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            holder= (Viewholder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2020-5-20");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://i0.hdslb.com/bfs/archive/4de86ebf90b044bf9ba2becf042a8977062b3f99.png").into(holder.imageView);
        return convertView;
    }
}
