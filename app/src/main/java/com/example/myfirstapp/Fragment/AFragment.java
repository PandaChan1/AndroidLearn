package com.example.myfirstapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfirstapp.R;

public class AFragment extends Fragment {
    private TextView mTvtitle;
//    private Activity mActivity;

    public static AFragment newInstance(String title){
        AFragment fragment=new AFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvtitle=view.findViewById(R.id.tv_titlea);
//        if (mActivity!=null){
//            //do something
//        }else{
//
//        }
        if (getArguments()!=null){
            mTvtitle.setText(getArguments().getString("title"));
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        mActivity= (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        //取消异步
//    }
}
