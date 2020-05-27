package com.example.myfirstapp.webView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myfirstapp.R;

public class webViewActivity extends AppCompatActivity {
private WebView mWebv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebv=findViewById(R.id.webv);
        //加载本地html
      //  mWebv.loadUrl("file:///android_asset/sup&sub.html");
        //加载网络url
        mWebv.getSettings().setJavaScriptEnabled(true); //设置可以加载JavaScript
        mWebv.setWebViewClient(new MyWebviewClient());   //在webview中加载点击后的页面
        mWebv.setWebChromeClient(new MyWebChromeClient());
        //mWebv.addJavascriptInterface(); 本地写javascript方法 Html调用本地javascript方法
        /*mWebv.evaluateJavascript();   //可以加载javascript代码
        mWebv.loadUrl();*/
        mWebv.loadUrl("https://m.baidu.com");
    }
    class MyWebviewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString()); //修改build。gradle 中minSdkVersion 为21 以使用getUrl()方法
            return true;
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted......");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPageFinished......");
            //mWebv.loadUrl("javascript:alert('hello')");
            mWebv.evaluateJavascript("javascript:alert('hello')",null);
            //evaluateJavascript最低要求SDK19  修改build。gradle中minSDKVersion为21
        }
    }
    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) { //网页加载时顶端的进度条
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //点击手机返回键 让其返回上一个webview页面
        if (keyCode==KeyEvent.KEYCODE_BACK && mWebv.canGoBack()){
            mWebv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
