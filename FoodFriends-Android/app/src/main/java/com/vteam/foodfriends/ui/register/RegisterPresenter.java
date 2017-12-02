package com.vteam.foodfriends.ui.register;

import android.content.Context;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.utils.Constant;

/**
 * Created by yukinohara on 12/2/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View mView;
    private Context mContext;
    private FirebaseUserService mDatabase;

    public RegisterPresenter(Context context, RegisterContract.View mView) {
        this.mContext = context;
        this.mView = mView;
        mView.setPresenter(this);
        mDatabase = new FirebaseUserService(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void register(String email, String password, String username, String phone, String dob, boolean isMale) {
        mDatabase.createUserWithEmail(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                    }
                });
    }
}
