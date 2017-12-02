package com.vteam.foodfriends.ui.messenger;

import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;
import com.vteam.foodfriends.ui.main.MainContract;

/**
 * Created by phuongbka on 12/2/17.
 */

public class MessengerContract {
    public interface Presenter extends BasePresenter {

    }

    public interface View extends BaseView<MessengerContract.Presenter> {
    }
}

