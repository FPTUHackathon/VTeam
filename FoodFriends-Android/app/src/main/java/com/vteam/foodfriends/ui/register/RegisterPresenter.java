package com.vteam.foodfriends.ui.register;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.preferences.AppPreferences;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.utils.Constant;

/**
 * Created by yukinohara on 12/2/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private static final String LOG_TAG = RegisterPresenter.class.getSimpleName();
    private RegisterContract.View mView;
    private Context mContext;
    private FirebaseUserService mDatabase;
    private AppPreferences mPreferences;

    public RegisterPresenter(Context context, RegisterContract.View mView) {
        this.mContext = context;
        this.mView = mView;
        mView.setPresenter(this);
        mDatabase = new FirebaseUserService(mContext);
        mPreferences = new AppPreferences(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void register(final String email, String password, final String username, final String phone, final String dob, final boolean isMale) {
        mDatabase.createUserWithEmail(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        FirebaseUser firebaseUser = mDatabase.getCurrentFirebaseUser();
                        User user = new User(email, username, phone, dob, isMale);
                        mDatabase.insertUser(firebaseUser, user);
                        mPreferences.setUser(user);
                        mView.startToHome();
                    }
                });


    }
}
