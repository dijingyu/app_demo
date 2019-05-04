package com.example.dijingyu.app_demo.base;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * 作者：邸某某
 * 时间：2019/4/30
 */

public class BaseApp extends Application {


    private static BaseApp sApp;
    private int mWidthPixels;
    private int mHeightPixels;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        UMConfigure.init(this,"5ccc34394ca35718030005f3"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        getScreenWH();
    }

    //计算屏幕宽高
    private void getScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
    }

    public static BaseApp getInstance(){
        return sApp;
    }

    public static Resources getRes() {
        return sApp.getResources();
    }

}
