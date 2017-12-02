package com.vteam.foodfriends.ui.register;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.base.BaseActivity;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.register_txt_email)
    TextInputEditText mEmail;
    @BindView(R.id.register_txt_username)
    TextInputEditText mUsername;
    @BindView(R.id.register_txt_password)
    TextInputEditText mPassword;
    @BindView(R.id.register_txt_phone)
    TextInputEditText mPhone;
    @BindView(R.id.register_txt_birth)
    TextInputEditText mBirthday;
    @BindView(R.id.rb_male)
    RadioButton mMale;
    @BindView(R.id.rb_female)
    RadioButton mFemale;

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    public void init() {

    }
}
