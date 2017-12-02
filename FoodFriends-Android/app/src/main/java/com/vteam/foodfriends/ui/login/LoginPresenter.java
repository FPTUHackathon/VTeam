package com.vteam.foodfriends.ui.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.preferences.AppPreferences;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.ui.main.MainActivity;
import com.vteam.foodfriends.utils.Constant;

/**
 * Created by H2PhySicS on 11/27/2017.
 */

public class LoginPresenter implements LoginContract.Presenter{
    private static final String LOG_TAG = LoginPresenter.class.getSimpleName();
    private LoginContract.View mView;
    private Context mContext;
    private FirebaseUserService mFirebaseUserService;
    private AppPreferences mPreferences;

    public LoginPresenter(Context context, LoginContract.View view, FirebaseUserService mFirebaseUserService){
        this.mView = view;
        this.mContext = context;
        mView.setPresenter(this);
        this.mFirebaseUserService = mFirebaseUserService;
        mPreferences = new AppPreferences(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void login(String username, String password) {
        mView.showLoadingIndicator(mContext.getString(R.string.sign_in));

        mFirebaseUserService.signInWithEmail(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.e(LOG_TAG, "Login successfully");
                            final FirebaseUser firebaseUser = mFirebaseUserService.getCurrentFirebaseUser();
                            mFirebaseUserService.getUserWithId(firebaseUser.getUid())
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            QuerySnapshot querySnapshot = task.getResult();
                                            DocumentSnapshot documentSnapshot = null;
                                            for (DocumentSnapshot d : querySnapshot){
                                                documentSnapshot = d;
                                                break;
                                            }
                                            if (documentSnapshot.exists()){
                                                String name = documentSnapshot.getString(Constant.FIREBASE_USER_USERNAME);
                                                String dob = documentSnapshot.getString(Constant.FIREBASE_USER_DOB);
                                                String phone = documentSnapshot.getString(Constant.FIREBASE_USER_PHONE);
                                                boolean isMale = documentSnapshot.getBoolean(Constant.FIREBASE_USER_GENDER);
                                                User user = new User(firebaseUser.getEmail(), name, phone, dob, isMale);
                                                mPreferences.setUser(user);
                                                mView.loginSuccess();
                                            }
                                        }
                                    });


                            mView.hideLoadingIndicator();
                            //Login successfully
                        } else {
                            Log.e(LOG_TAG, "Login failed");
                            mView.hideLoadingIndicator();
                            mView.showErrorDialog(mContext.getString(R.string.error_login_title));
                        }
                    }
                });
    }



}
