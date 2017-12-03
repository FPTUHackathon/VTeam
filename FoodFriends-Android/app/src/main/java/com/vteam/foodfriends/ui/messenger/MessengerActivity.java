package com.vteam.foodfriends.ui.messenger;

import android.view.View;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.base.BaseActivity;

public class MessengerActivity extends BaseActivity implements MessengerContract.View, View.OnClickListener {
    private static final String LOG_TAG = MessengerActivity.class.getSimpleName();
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
        return R.layout.activity_messenger;
    }

    @Override
    public void init() {

    }
}
