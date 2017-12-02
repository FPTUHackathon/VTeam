package com.vteam.foodfriends.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.main.MainActivity;
import com.vteam.foodfriends.utils.SnackbarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();
    private LoginContract.Presenter mPresenter;

    @BindView(R.id.txt_email)
    TextInputEditText mTextEmail;
    @BindView(R.id.txt_password)
    TextInputEditText mTextPassword;
    @BindView(R.id.bt_login)
    Button mLogin;
    @BindView(R.id.bt_register)
    Button mRegister;
    @BindView(R.id.tv_forgot_password)
    TextView mForgotPassword;
    @BindView(R.id.login_screen)
    RelativeLayout mLoginScreen;
    FirebaseUser firebaseuser;
    String uid;

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void startForgotPassword() {

    }

    @Override
    public void loginSuccess(FirebaseUser user) {
        mPresenter.fetchUserId(user);
        startActivityWithAnimation(new Intent(this, MainActivity.class));
    }

    @Override
    public void showDataUser(User user) {

    }


    @Override
    public void registerSuccess() {
        startActivityWithAnimation(new Intent(this, MainActivity.class));
    }

    @Override
    public void showRegisterDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle(getString(R.string.register_title));
        alertDialog.setMessage(getString(R.string.register_message));
        LayoutInflater inflater = LayoutInflater.from(this);
        View registerLayout = inflater.inflate(R.layout.layout_register, null);

        final TextInputEditText mEmail = registerLayout.findViewById(R.id.register_txt_email);
        final TextInputEditText mPassword = registerLayout.findViewById(R.id.register_txt_password);
        final TextInputEditText mUsername = registerLayout.findViewById(R.id.register_txt_username);
        final TextInputEditText mPhone = registerLayout.findViewById(R.id.register_txt_phone);

        alertDialog.setView(registerLayout);

        //Set Button
        alertDialog.setPositiveButton(getString(R.string.register_title), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String username = mUsername.getText().toString();
                String phone = mPhone.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    SnackbarUtils.getInstance(mLoginScreen, getString(R.string.email_requirement)).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    SnackbarUtils.getInstance(mLoginScreen, getString(R.string.password_requirement)).show();
                    return;
                }
                if (TextUtils.isEmpty(username)) {
                    SnackbarUtils.getInstance(mLoginScreen, getString(R.string.username_requirement)).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    SnackbarUtils.getInstance(mLoginScreen, getString(R.string.phone_requirement)).show();
                    return;
                }

                //check password too short
                if (password.length() < 6) {
                    SnackbarUtils.getInstance(mLoginScreen, getString(R.string.password_requirement_error)).show();
                }

                //Register
                mPresenter.register(email, password, username, phone);
            }
        });

        alertDialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public void showLoadingIndicator(String message) {
        if (message == null) {
            showLoading();
        } else {
            showLoading(message);
        }
        enableTouchable(true);
    }

    @Override
    public void hideLoadingIndicator() {
        hideLoading();
        enableTouchable(false);
    }

    @Override
    public void showErrorDialog(String message) {
        showAlert(getString(R.string.error_login_title), message);
    }

    @Override
    public void focusedOnActivity(boolean focused) {
        if (focused) {
            mLoginScreen.setFocusable(true);
        } else {
            mLoginScreen.setFocusable(false);
        }
    }

    @Override
    public void init() {
        mPresenter = new LoginPresenter(this, this, new FirebaseUserService(this));

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mForgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String username = mTextEmail.getText().toString();
        String password = mTextPassword.getText().toString();
        switch (id) {
            case R.id.bt_login: {
                mPresenter.login(username, password);
                break;
            }
            case R.id.bt_register: {
                showRegisterDialog();
                break;
            }
            case R.id.tv_forgot_password: {
                startForgotPassword();
                break;
            }
        }
    }

}
