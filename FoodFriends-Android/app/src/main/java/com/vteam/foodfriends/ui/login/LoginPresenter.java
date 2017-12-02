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

/**
 * Created by H2PhySicS on 11/27/2017.
 */

public class LoginPresenter implements LoginContract.Presenter{
    private static final String LOG_TAG = LoginPresenter.class.getSimpleName();
    private LoginContract.View mView;
    private FirebaseAuth mAuth;
    private Context mContext;
    private FirebaseUserService mFirebaseUserService;
    private AppPreferences mPreferences;
    String id;

    public LoginPresenter(Context context, LoginContract.View view, FirebaseUserService mFirebaseUserService){
        this.mView = view;
        this.mContext = context;
        mView.setPresenter(this);
        mAuth = FirebaseAuth.getInstance();
        this.mFirebaseUserService = mFirebaseUserService;
        mPreferences = new AppPreferences(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mAuth.signOut();
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
                            FirebaseUser user = mAuth.getCurrentUser();
                            mView.loginSuccess(user);
                            mView.hideLoadingIndicator();

                            //Login successfully
                        } else {
                            Log.e(LOG_TAG, "Login failed");
                            mView.showErrorDialog(mContext.getString(R.string.error_login_title));
                        }
                    }
                });
    }

    @Override
    public void fetchUserId(FirebaseUser user) {
        id = mFirebaseUserService.getUid(user);
        Log.d(LOG_TAG," id"+ id);

        Task<QuerySnapshot> task = mFirebaseUserService.getUserData(id);
        task.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot document: task.getResult()){

                    }
                }
            }
        });
    }


    @Override
    public void register(final String email, String password, String username, String phone) {
        mView.showLoadingIndicator(mContext.getString(R.string.sign_up));
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        mView.hideLoadingIndicator();
//                        User user = new User();
//                        user.setEmail(mEmail.getText().toString());
//                        user.setName(mUsername.getText().toString());
//                        user.setPassword(mPassword.getText().toString());
//                        user.setPhone(mPhone.getText().toString());
//
//                        //Use email to key
//                        mUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                .setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Snackbar.make(mLoginScreen, "Register Succesfully", Snackbar.LENGTH_LONG).show();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Snackbar.make(mLoginScreen, "Failed " + e.getMessage(), Snackbar.LENGTH_LONG).show();
//                            }
//                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
//                Snackbar.make(mLoginScreen, "Failed " + e.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
