package com.example.myfirstapp.RecylerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.R;

public class pubuAdapter extends RecyclerView.Adapter<pubuAdapter.PubuHolder> {  //不添加泛型会报错
    private Context mContext;
    private OnItemClickLinstener mLinstener;
    public pubuAdapter(Context context,OnItemClickLinstener linstener){
        this.mContext=context;
        this.mLinstener=linstener;
    }
    @NonNull
    @Override
    public pubuAdapter.PubuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PubuHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_pubu,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull pubuAdapter.PubuHolder holder, final int position) {
      if (position % 2 != 0) {
          holder.imageView.setImageResource(R.drawable.guihua);
      }else{
          holder.imageView.setImageResource(R.drawable.taohua_2);
      }
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLinstener.onClick(position);
        }
    });
    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class PubuHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public PubuHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.iv_pubu);
        }
    }
    public interface  OnItemClickLinstener{
        void onClick(int pos);
    }
}
