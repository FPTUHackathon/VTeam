package com.vteam.foodfriends.ui.login;

import com.google.firebase.auth.FirebaseAuth;
import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

/**
 * Created by H2PhySicS on 11/27/2017.
 */

public class LoginContract {

    public interface Presenter extends BasePresenter{
        void login(String username, String password);
        void register(String email, String password, String username, String phone);
    }

    public interface View extends BaseView<Presenter>{
        void startForgotPassword();
        void loginSuccess();
        void registerSuccess();
        void showRegisterDialog();
        void showLoadingIndicator(String message);
        void hideLoadingIndicator();
        void showErrorDialog(String message);
        void focusedOnActivity(boolean focused);
    }

}
