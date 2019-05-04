package com.example.dijingyu.app_demo.ui.main;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dijingyu.app_demo.R;
import com.example.dijingyu.app_demo.base.BaseActivity;
import com.example.dijingyu.app_demo.mvp.presenter.EmptyP;
import com.example.dijingyu.app_demo.mvp.view.EmptyV;
import com.umeng.qq.handler.UmengQQHandler;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import static com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.mContext;

public class LoginActivity extends BaseActivity<EmptyP,EmptyV> implements EmptyV {


    private TextView mTv;
    private ImageView mWeChat;

    @Override
    protected void initView() {
        mTv = findViewById(R.id.login_tv_service);
        mWeChat = findViewById(R.id.iv_weChat);
        String string = getResources().getString(R.string.login_service);
        SpannableString spannableString = new SpannableString(string);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "用户协议", Toast.LENGTH_SHORT).show();
            }
            //123
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(ContextCompat.getColor(LoginActivity.this, R.color.service));//设置颜色
                ds.setUnderlineText(true);//添加下划线
            }
        };
        spannableString.setSpan(clickableSpan, string.length() - 4, string.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mTv.setText(spannableString);
        mTv.setMovementMethod(LinkMovementMethod.getInstance());
        mWeChat.setOnClickListener(new View.OnClickListener() {
            UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this);

            @Override
            public void onClick(View v) {
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show();
            
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(mContext, "失败：" + t.getMessage(),                                     Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected EmptyP initPresenter() {
        return null;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(Object bean) {

    }

    @Override
    public void onFail(String tips) {

    }
}
