package com.yf.istudy.fragment;

import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yf.istudy.R;
import com.yf.istudy.adapter.NewsAdapter;

/**
 * Created by Administrator on 2016/11/16.
 */

public class NewsFragment extends Fragment {
    private ListView newsLv;
    private View view;
    private NewsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_news,container,false);
        initView();
        return view;
    }

    private void initView() {
        newsLv= (ListView) view.findViewById(R.id.newsLv);
        mAdapter=new NewsAdapter(getActivity());

    }

    class  GetNewsTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
            return null;
        }
    }
}
