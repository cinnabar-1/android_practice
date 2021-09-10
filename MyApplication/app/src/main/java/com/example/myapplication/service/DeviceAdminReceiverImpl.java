package com.example.myapplication.service;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DeviceAdminReceiverImpl extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Log.v(">>>>>>>>>", "onEnabled");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.v(">>>>>>>>>", "onReceive");
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        //这里如果返回的字符串不为空，那么当用户去设置里取消时，则会提示带此文字的确定框
        String strResult = "取消时便不能使用免root停用应用";
        Log.v(">>>>>>>>>", "onDisableRequested");
        return strResult;
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        Log.v(">>>>>>>>>", "onDisabled");
    }
}
