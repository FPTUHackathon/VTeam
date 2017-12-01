package com.vteam.foodfriends.ui.introduction;

import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

/**
 * Created by H2PhySicS on 11/30/2017.
 */

public class IntroContract {
    public interface Presenter extends BasePresenter{

    }

    public interface View extends BaseView<Presenter>{
        void launchLoginScreen();
    }
}
