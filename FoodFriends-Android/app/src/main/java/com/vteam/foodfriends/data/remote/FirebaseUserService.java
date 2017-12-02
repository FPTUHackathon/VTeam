package com.vteam.foodfriends.data.remote;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by yukinohara on 12/2/17.
 */

public class FirebaseUserService {
    private Context mContext;
    private FirebaseAuth mAuth;

    public FirebaseUserService(Context context){
        this.mContext = context;
        mAuth = FirebaseAuth.getInstance();
    }

    public Task<AuthResult> signInWithEmail(String email, String password){
        return mAuth.signInWithEmailAndPassword(email, password);
    }

    public Task<AuthResult> createUserWithEmail(String email, String password){
        return mAuth.createUserWithEmailAndPassword(email, password);
    }

    public void logOut(){
        mAuth.signOut();
    }

}
