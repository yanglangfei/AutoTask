package com.yf.autotask;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;

import com.yf.autotask.view.RecoderView;

import java.net.URISyntaxException;
import java.util.Random;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RecoderView rv;
    private  int colors[]={Color.YELLOW,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY};
    private  int index=1;
    private  int  width;
    private  boolean isNight=false;
    private RelativeLayout mActivityMain;
    private Button mSwitchModel;
    private ClipboardManager clipboardManager;
    private Button mCopyBtn;
    private Button mParseBtn;
    private TextView parseBody;
    private  Button parseIntentBtn;
    private  Button copyIntentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自动设置日间  夜间模式切换
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        clipboardManager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        parseBody= (TextView) findViewById(R.id.parseBody);
        mCopyBtn = (Button) findViewById(R.id.copyBtn);
        mParseBtn = (Button) findViewById(R.id.parseBtn);
        parseIntentBtn= (Button) findViewById(R.id.parseIntentBtn);
        copyIntentBtn= (Button) findViewById(R.id.copyIntentBtn);
        copyIntentBtn.setOnClickListener(this);
        parseIntentBtn.setOnClickListener(this);


        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
        mSwitchModel = (Button) findViewById(R.id.switchModel);
        mSwitchModel.setOnClickListener(this);
        mSwitchModel.setText("日间模式");
        mCopyBtn.setOnClickListener(this);
        mParseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.switchModel:
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
                break;
            case R.id.copyBtn:
                copysText();
                break;
            case R.id.parseBtn:
                pasteText();
                break;
            case R.id.parseIntentBtn:
                pasteIntent();
                break;
            case R.id.copyIntentBtn:
                copyIntent();
                break;
            default:
                break;
        }
    }


    /**
     *  copy 字符串
     */
    public  void copysText(){
        String str="hello copy";
        ClipData data=ClipData.newPlainText("test",str);
        clipboardManager.setPrimaryClip(data);
    }

    /**
     *  粘贴字符串
     */
    public void pasteText(){
        ClipData data = clipboardManager.getPrimaryClip();
        ClipData.Item item = data.getItemAt(0);
        String str=item.getText().toString();
        parseBody.setText("粘贴:"+str);
    }


    /**
     *   copy 可以打开activity 的 intent
     */
    public  void copyIntent(){
        Intent intent=new Intent();
        intent.setComponent(new ComponentName("com.yf.istudy","com.yf.istudy.MainActivity"));
        intent.putExtra("uId",10);
        intent.setAction(Intent.ACTION_VIEW);
        ClipData data=ClipData.newIntent("intent",intent);
        clipboardManager.setPrimaryClip(data);
    }

    /**
     *   获取 copy 的 intent 并打开对应的 activity
     */
    public void pasteIntent(){
        ClipData data = clipboardManager.getPrimaryClip();
        ClipData.Item item = data.getItemAt(0);
        String str=item.coerceToText(getApplicationContext()).toString();
        try {
            Intent intent=Intent.parseUri(str,0);
            startActivity(intent);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
