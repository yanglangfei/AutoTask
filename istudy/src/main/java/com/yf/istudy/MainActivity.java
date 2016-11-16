package com.yf.istudy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.yf.istudy.fragment.BlogFragment;
import com.yf.istudy.fragment.NewsFragment;
import com.yf.istudy.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout mBlogLay;
    private RelativeLayout mNewsLay;
    private RelativeLayout mVideoLay;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fm=getSupportFragmentManager();
        mBlogLay = (RelativeLayout) findViewById(R.id.blogLay);
        mNewsLay = (RelativeLayout) findViewById(R.id.newsLay);
        mVideoLay = (RelativeLayout) findViewById(R.id.videoLay);
        mBlogLay.setOnClickListener(this);
        mNewsLay.setOnClickListener(this);
        mVideoLay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ft=fm.beginTransaction();
        switch (v.getId()){
            case R.id.blogLay:
                 ft.replace(R.id.fragment,new BlogFragment()).commit();
                break;
            case R.id.newsLay:
                ft.replace(R.id.fragment,new NewsFragment()).commit();
                break;
            case R.id.videoLay:
                ft.replace(R.id.fragment,new VideoFragment()).commit();
                break;
            default:
                break;
        }
    }
}
