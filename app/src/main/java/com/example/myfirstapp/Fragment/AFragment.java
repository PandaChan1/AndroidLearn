package com.example.myfirstapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfirstapp.R;

public class AFragment extends Fragment {
    private TextView mTvtitle;
//    private Activity mActivity;
    private Button mBtnChange;
    private BFragment bFragment;
    private Button mBtnreset;
    private Button mBtnsendmessage;
    private IOnMessageClick linstener;

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
        Log.d("AFragment","—————onCreateView—————");
        return view;
    }
    public interface IOnMessageClick{
        void onClick(String test);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvtitle=view.findViewById(R.id.tv_titlea);
        mBtnChange=view.findViewById(R.id.btn_change);
        mBtnreset=view.findViewById(R.id.btn_reset);
        mBtnsendmessage=view.findViewById(R.id.btn_sendmessage);
        mBtnsendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");
                linstener.onClick("你好");
            }
        });

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment==null){
                    bFragment=new BFragment();
                }
                Fragment fragment=getFragmentManager().findFragmentByTag("a");
                if (fragment!=null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }


            }
        });

        mBtnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvtitle.setText("我是新文字");
            }
        });

        if (getArguments()!=null){
            mTvtitle.setText(getArguments().getString("title"));
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        mActivity= (Activity) context;
       try {
           linstener= (IOnMessageClick) context;
       }catch (ClassCastException e){
        throw new ClassCastException("Activity必须实现IOnMessageClick接口");
       }

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
