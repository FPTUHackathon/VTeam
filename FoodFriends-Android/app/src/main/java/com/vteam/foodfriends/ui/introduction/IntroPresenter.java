package com.vteam.foodfriends.ui.introduction;

/**
 * Created by H2PhySicS on 11/30/2017.
 */

public class IntroPresenter implements IntroContract.Presenter{
    IntroContract.View mView;

    public IntroPresenter(IntroContract.View view) {
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
