package com.example.dijingyu.app_demo.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.dijingyu.app_demo.R;
import com.example.dijingyu.app_demo.ui.PhoneActivity;

/**
 * 作者：邸某某
 * 时间：2019/4/30
 */

public class EditedPhone extends RelativeLayout {

    public EditedPhone(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_edtext_phone,this);
        initView();
    }

    private void initView() {
        final Button send = findViewById(R.id.bt_send);
        final EditText phone = findViewById(R.id.ed_phone);
        TextWatcher edibility = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            //一般我们都是在这个里面进行我们文本框的输入的判断，上面两个方法用到的很少
            @Override
            public void afterTextChanged(Editable s) {
                String money = phone.getText().toString();
                if (money.length()>0) {
                    send.setBackgroundResource(R.drawable.bg_login_button_on);
                    send.setEnabled(true);
                }else {
                    send.setBackgroundResource(R.drawable.bg_login_button);
                    send.setEnabled(false);
                }
            }
        };
        phone.addTextChangedListener(edibility);
        setTouchListener((Activity) getContext());//只需调用这个方法即可;
        send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getContext(), PhoneActivity.class);
                    getContext().startActivity(intent);
            }
        });
    }

    public void setTouchListener(final Activity context) {
        context.getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager)
                        context.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (context.getCurrentFocus() != null) {
                    assert imm != null;
                    imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
                } else {
                    assert imm != null;
                    imm.hideSoftInputFromWindow((context.findViewById(android.R.id.content)).getWindowToken(), 0);
                }
                return false;
            }
        });

    }

}
