package com.vteam.foodfriends.ui.register;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.main.MainActivity;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, RegisterContract.View{
    private static final String LOG_TAG = RegisterActivity.class.getSimpleName();

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
    @BindView(R.id.btn_register)
    Button mRegister;

    private RegisterContract.Presenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    public void init() {
        mPresenter = new RegisterPresenter(this, this);

        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        Log.e(LOG_TAG, "OnClick");
        if (TextUtils.isEmpty(mEmail.getText()) ||
                TextUtils.isEmpty(mPassword.getText()) ||
                TextUtils.isEmpty(mUsername.getText()) ||
                TextUtils.isEmpty(mPhone.getText()) ||
                TextUtils.isEmpty(mBirthday.getText())){
            return;
        }
        mPresenter.register(mEmail.getText().toString(),
                mPassword.getText().toString(),
                mUsername.getText().toString(),
                mPhone.getText().toString(),
                mBirthday.getText().toString(),
                mMale.isChecked());

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void startToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityWithAnimation(intent);
        finish();
    }
}
