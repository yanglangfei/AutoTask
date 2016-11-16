package com.yf.autotask;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.yf.autotask.view.RecoderView;

import java.util.Random;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RecoderView rv;
    private  int colors[]={Color.YELLOW,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY};
    private  int index=1;
    private  int  width;
    private  boolean isNight=false;
    private RelativeLayout mActivityMain;
    private Button mSwitchModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自动设置日间  夜间模式切换
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);


        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
        mSwitchModel = (Button) findViewById(R.id.switchModel);
        mSwitchModel.setOnClickListener(this);
        mSwitchModel.setText("日间模式");
    }

    @Override
    public void onClick(View v) {
        if(!isNight){
            mSwitchModel.setText("夜间模式");
            isNight=true;
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            recreate();
        }else {
            isNight=false;
            mSwitchModel.setText("日间模式");
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        }

    }
}
