package com.example.dijingyu.app_demo.ui;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dijingyu.app_demo.R;
import com.example.dijingyu.app_demo.base.BaseActivity;
import com.example.dijingyu.app_demo.mvp.presenter.EmptyP;
import com.example.dijingyu.app_demo.mvp.view.EmptyV;

public class PersonageShowActivity extends BaseActivity<EmptyP,EmptyV> implements EmptyV{

    private Toolbar mToolbar;

    /**
     * 个人信息
     */


    @Override
    protected void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setNavigationIcon(R.mipmap.big_arrow_left);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected EmptyP initPresenter() {
        return null;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_personage_show;
    }

    @Override
    public void onSuccess(Object bean) {

    }

    @Override
    public void onFail(String tips) {

    }
}
