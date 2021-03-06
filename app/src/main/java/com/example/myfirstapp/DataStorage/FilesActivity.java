package com.example.myfirstapp.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfirstapp.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesActivity extends AppCompatActivity {
    private EditText mEtfilecontent;
    private Button mBtnfilesave,mBtnfileshow;
    private TextView mTvfileshared;
    private  final String mFilename="text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);
        mEtfilecontent=findViewById(R.id.et_filecontent);
        mBtnfilesave=findViewById(R.id.btn_filesave);
        mBtnfileshow=findViewById(R.id.btn_fileshow);
        mTvfileshared=findViewById(R.id.tv_fileshare);

        mBtnfileshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvfileshared.setText(read());

            }
        });

        mBtnfilesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtfilecontent.getText().toString());

            }
        });


    }
    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream =null;
        try {
//            内部存储
//            fileOutputStream=openFileOutput(mFilename,MODE_PRIVATE);
            //外部存储
            //创建文件夹
            File dir=new File(Environment.getExternalStorageDirectory(),"cy");
            if(!dir.exists()){
                dir.mkdir();
            }
            File file=new File(dir,mFilename);
            //创建文件
            if (!file.exists()){
                file.createNewFile();
            }
            fileOutputStream=new FileOutputStream(file);


            fileOutputStream.write(content.getBytes());

        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //读取数据
    private String read(){
        FileInputStream fileInputStream=null;
        try {
//            //内部存储读取
//            fileInputStream=openFileInput(mFilename);
            //设置文件路径
            File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"cy",mFilename);
            fileInputStream=new FileInputStream(file);
            byte[] buff=new byte[1024]; //一次读取1024字节
            StringBuilder sb=new StringBuilder(""); //实现拼接
            int len=0;
            while((len=fileInputStream.read(buff))>0){
                sb.append(new String(buff,0,len));
                return sb.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
