package com.example.myfirstapp.RecylerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.R;

public class HoriAdapter extends RecyclerView.Adapter<HoriAdapter.LinearHolder> {
    private Context mContext;
    private  OnItemClickLinstener mlinstener;
    public HoriAdapter(Context context, OnItemClickLinstener linstener){
        this.mContext=context;
        this.mlinstener=linstener;
    }
    @NonNull
    @Override
    public HoriAdapter.LinearHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hori,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HoriAdapter.LinearHolder holder, final int position) {
        holder.textView.setText("Hello hk!");
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"ckick..."+position,Toast.LENGTH_SHORT).show();
                mlinstener.onClick(position);
            }
        });

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
    public interface  OnItemClickLinstener{
        void onClick(int pos);
    }
}
