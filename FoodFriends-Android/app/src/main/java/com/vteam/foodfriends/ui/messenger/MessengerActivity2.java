package com.vteam.foodfriends.ui.messenger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.base.BaseActivity;

public class MessengerActivity2 extends BaseActivity implements MessengerContract.View, View.OnClickListener {
    private static final String LOG_TAG = MessengerActivity2.class.getSimpleName();
    private MessengerContract.Presenter mPresenter;

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setPresenter(MessengerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_messenger2;
    }

    @Override
    public void init() {

    }
}
