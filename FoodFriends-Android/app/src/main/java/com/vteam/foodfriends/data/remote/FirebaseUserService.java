package com.vteam.foodfriends.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.data.model.User;

import static android.content.ContentValues.TAG;

/**
 * Created by yukinohara on 12/2/17.
 */

public class FirebaseUserService {
    private Context mContext;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    public FirebaseUserService(Context context){
        this.mContext = context;
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    public String getUid(FirebaseUser user){
        return user.getUid();
    }

    public Task<AuthResult> signInWithEmail(String email, String password){
        return mAuth.signInWithEmailAndPassword(email, password);
    }

    public Task<AuthResult> createUserWithEmail(String email, String password){
        return mAuth.createUserWithEmailAndPassword(email, password);
    }

    public Task<QuerySnapshot> getUserData(String uid){
        return db.collection("users").whereEqualTo(uid,true).get();
    }

    public void insertUser(User user){

    }

    public void logOut(){
        mAuth.signOut();
    }

}
