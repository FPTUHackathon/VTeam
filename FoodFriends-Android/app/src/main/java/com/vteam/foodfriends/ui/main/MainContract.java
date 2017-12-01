package com.vteam.foodfriends.ui.main;

import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

/**
 * Created by H2PhySicS on 11/27/2017.
 */

public class MainContract {
    public interface Presenter extends BasePresenter{

    }

    public interface View extends BaseView<Presenter>{
        void spaceNavigationView();
    }
}
