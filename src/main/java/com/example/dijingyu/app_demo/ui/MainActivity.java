package com.example.dijingyu.app_demo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.dijingyu.app_demo.R;
import com.example.dijingyu.app_demo.base.BaseActivity;
import com.example.dijingyu.app_demo.mvp.presenter.EmptyP;
import com.example.dijingyu.app_demo.mvp.view.EmptyV;

public class MainActivity extends BaseActivity<EmptyP,EmptyV> implements EmptyV{

    private Toolbar mToolbar;
    private RelativeLayout mPersonage;

    @Override
    protected void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mPersonage = findViewById(R.id.personage_relative);
        mPersonage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonageShowActivity.class);
                startActivity(intent);
            }
        });
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected EmptyP initPresenter() {
        return null;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object bean) {

    }

    @Override
    public void onFail(String tips) {

    }
}
