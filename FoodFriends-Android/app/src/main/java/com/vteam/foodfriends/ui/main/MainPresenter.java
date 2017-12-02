package com.vteam.foodfriends.ui.main;

import android.content.Context;

import com.vteam.foodfriends.ui.login.LoginContract;
import com.vteam.foodfriends.ui.login.LoginPresenter;

/**
 * Created by phuongbka on 11/30/17.
 */

public class MainPresenter implements MainContract.Presenter {
    private static final String LOG_TAG = MainPresenter.class.getSimpleName();
    private MainContract.View mView;
    private Context mContext;

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
