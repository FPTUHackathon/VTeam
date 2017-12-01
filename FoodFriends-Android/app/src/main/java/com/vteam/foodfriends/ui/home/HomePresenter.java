package com.vteam.foodfriends.ui.home;

import android.content.Context;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public class HomePresenter implements HomeContract.Presenter{
    private HomeContract.View mView;
    private Context mContext;

    public HomePresenter(Context context, HomeContract.View view) {
        this.mContext = context;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
