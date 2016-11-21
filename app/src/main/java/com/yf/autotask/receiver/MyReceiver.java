package com.yf.autotask.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/21.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals(Intent.ACTION_BATTERY_LOW)){
            Toast.makeText(context, "电量低，请及时充电", Toast.LENGTH_SHORT).show();
        }
        if(action.equals(Intent.ACTION_BATTERY_OKAY)){
            Toast.makeText(context, "充电完成", Toast.LENGTH_SHORT).show();
        }

        if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
            Toast.makeText(context, "电量改变", Toast.LENGTH_SHORT).show();
        }
        
        if(action.equals(Intent.ACTION_PACKAGE_ADDED)){
            Toast.makeText(context, "安装apk", Toast.LENGTH_SHORT).show();
        }
        
        if(action.equals(Intent.ACTION_UNINSTALL_PACKAGE)){
            Toast.makeText(context, "卸载apk", Toast.LENGTH_SHORT).show();
        }

        if(action.equals(Intent.ACTION_SCREEN_ON)){
            Toast.makeText(context, "屏幕解锁状态", Toast.LENGTH_SHORT).show();
        }

        if(action.equals(Intent.ACTION_SCREEN_OFF)){
            Toast.makeText(context, "屏幕锁定状态", Toast.LENGTH_SHORT).show();
        }

        if(action.equals(Intent.ACTION_USER_PRESENT)){
            Toast.makeText(context, "用户解锁屏幕", Toast.LENGTH_SHORT).show();
        }


    }
}
