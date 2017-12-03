package com.vteam.foodfriends.ui.update;

import android.content.Context;

import com.vteam.foodfriends.data.remote.FirebaseRestaurantService;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.ui.home.HomeContract;
import com.vteam.foodfriends.ui.home.HomePresenter;

/**
 * Created by phuongbka on 12/3/17.
 */

public class UpdatePresenter implements UpdateContract.Presenter {
    private static final String LOG_TAG = HomePresenter.class.getSimpleName();
    private UpdateContract.View mView;
    private Context mContext;

    public UpdatePresenter(Context context, UpdateContract.View view) {
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
