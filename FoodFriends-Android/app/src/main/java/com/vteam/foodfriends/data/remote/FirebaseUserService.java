package com.vteam.foodfriends.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.utils.Constant;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by yukinohara on 12/2/17.
 */

public class FirebaseUserService {
    private static final String LOG_TAG = FirebaseUserService.class.getSimpleName();
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

    public void insertUser(FirebaseUser firebaseUser, User user){
        Map<String, Object> mapUserDetail = new HashMap<>();
        mapUserDetail.put(Constant.FIREBASE_USER_ID, firebaseUser.getUid());
        mapUserDetail.put(Constant.FIREBASE_USER_USERNAME, user.getName());
        mapUserDetail.put(Constant.FIREBASE_USER_PHONE, user.getPhone());
        mapUserDetail.put(Constant.FIREBASE_USER_DOB, user.getDob());
        mapUserDetail.put(Constant.FIREBASE_USER_GENDER, user.isMale());
        mapUserDetail.put(Constant.FIREBASE_USER_AVATAR, user.getAvatar());
//        mapUserDetail.put(Constant.FIREBASE_USER_FOLLOWS, user.getFollows());

        db.collection("users")
                .add(mapUserDetail)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.e(LOG_TAG, "OnSuccess");
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Log.e(LOG_TAG, "OnComplete");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(LOG_TAG, "OnFailure");
                    }
                });

    }

    public FirebaseUser getCurrentFirebaseUser(){
        return mAuth.getCurrentUser();
    }

    public Task<QuerySnapshot> getUserWithId(String id){
        return db.collection("users")
                .whereEqualTo(Constant.FIREBASE_USER_ID, id)
                .get();
    }

    public void logOut(){
        mAuth.signOut();
    }

}
