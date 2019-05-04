package com.example.dijingyu.app_demo.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 作者：邸某某
 * 时间：2019/4/30
 */

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity{

    P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(getActivityLayoutId());
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.addView((V)this);
        }
        initView();
    }

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int getActivityLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
        mPresenter = null;
    }

}
