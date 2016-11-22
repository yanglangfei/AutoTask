package com.yf.autotask;

import android.app.Activity;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
/**
 * Created by Administrator on 2016/11/22.
 */
public class TestActivity extends Activity implements View.OnClickListener {
    private Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_test);
        btnTest= (Button) findViewById(R.id.btnTest);
        btnTest.setHapticFeedbackEnabled(true);
        btnTest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         //震动反馈  不需要震动权限
        //   btnTest.isHapticFeedbackEnabled()  为true 时并且已设置震动反馈才起作用
        v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        //忽略 btnTest.isHapticFeedbackEnabled()  为true的条件   只要设置震动反馈就生效
        v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS,HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
        //忽略设置震动反馈  只要 btnTest.isHapticFeedbackEnabled()  为true就生效
        v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS,HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);

        //点击事件的自动执行
        v.performClick();
        //长按事件的自动执行
        v.performLongClick();
    }
}
