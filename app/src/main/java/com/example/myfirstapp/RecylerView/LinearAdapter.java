package com.example.myfirstapp.RecylerView;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private  OnItemClickLinstener mlinstener;
    public LinearAdapter(Context context, OnItemClickLinstener linstener){
        this.mContext=context;
        this.mlinstener=linstener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0)
        {
            return new LinearHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear,parent,false));
        }else{
            return new LinearHolderImage(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==0){
            ((LinearHolder)holder).textView.setText("Hello world!");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mContext,"ckick..."+position,Toast.LENGTH_SHORT).show();
                    mlinstener.onClick(position);
                }
            });
        }else{
            ( (LinearHolderImage)holder).textView.setText("HuaK");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mlinstener.onClick(position);
                }
            });
        }
        

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0 ){
            return  0;
        }else
        {
            return 1;
        }
    }

    @Override
    public int getItemCount() { //列表长度
        return 30;
    }
    class LinearHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }
    class LinearHolderImage extends  RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public LinearHolderImage(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_tittle_linear2);
            imageView=itemView.findViewById(R.id.iv_image_linear2);
        }
    }
    public interface  OnItemClickLinstener{
        void onClick(int pos);
    }
}
