package com.vteam.foodfriends.ui.register;

import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

/**
 * Created by yukinohara on 12/2/17.
 */

public class RegisterContract {
    public interface Presenter extends BasePresenter{
        void register(String email, String password, String username, String phone, String dob, boolean isMale);
    }

    public interface View extends BaseView<Presenter>{

    }
}
