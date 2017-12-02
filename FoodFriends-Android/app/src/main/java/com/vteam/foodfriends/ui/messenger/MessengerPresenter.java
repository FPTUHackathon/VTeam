package com.vteam.foodfriends.ui.messenger;

import android.content.Context;

import com.vteam.foodfriends.ui.login.LoginPresenter;
import com.vteam.foodfriends.ui.main.MainContract;

/**
 * Created by phuongbka on 12/2/17.
 */

public class MessengerPresenter implements MessengerContract.Presenter {
    private static final String LOG_TAG = MessengerPresenter.class.getSimpleName();
    private MessengerContract.View mView;
    private Context mContext;

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
