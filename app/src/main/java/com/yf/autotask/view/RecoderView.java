package com.yf.autotask.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.IllegalFormatWidthException;

/**
 * Created by Administrator on 2016/11/15.
 */

public class RecoderView extends View {
    private  Context context;
    private Paint mPaint;
    private  int index=1;
    private  int color;
    private IllegalFormatWidthException display;

    public RecoderView(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    private void initView() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setAlpha(120);
    }

    public RecoderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(100,100,100,mPaint);
        mPaint.setColor(color);
        canvas.drawCircle(100,100,index,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


}

