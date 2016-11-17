package com.yf.autotask;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Administrator on 2016/11/17.
 */

public class WelconActivity extends BaseActivity {
    private  WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_welcom);
        wv= (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
       // wv.loadUrl();
    }

    public  void  onJs(View view){

    }
}
