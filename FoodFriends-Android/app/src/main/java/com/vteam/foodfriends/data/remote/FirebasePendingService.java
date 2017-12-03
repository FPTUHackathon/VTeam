package com.vteam.foodfriends.data.remote;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.utils.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yukinohara on 12/2/17.
 */

public class FirebasePendingService {
    private static final String LOG_TAG = FirebasePendingService.class.getSimpleName();
    private Context mContext;
    private FirebaseFirestore db;

    public FirebasePendingService(Context context){
        this.mContext = context;
        db = FirebaseFirestore.getInstance();
    }

    public Task<Void> createPair(String resId, List<Map<String, Object>> pairedList, User user, String createTime){
        Map<String, Object> paired = new HashMap<>();
        Map<String, Object> newPair = new HashMap<>();
        Map<String, Object> userCreateMap = new HashMap<>();
        userCreateMap.put(Constant.FIREBASE_USER_ID, user.getId());
        userCreateMap.put(Constant.FIREBASE_USER_EMAIL, user.getEmail());
        userCreateMap.put(Constant.FIREBASE_USER_USERNAME, user.getName());
        userCreateMap.put(Constant.FIREBASE_USER_PHONE, user.getPhone());
        userCreateMap.put(Constant.FIREBASE_USER_DOB, user.getDob());
        userCreateMap.put(Constant.FIREBASE_USER_GENDER, user.isMale());
        newPair.put(Constant.FIREBASE_PENDING_PAIR_USER_CREATE, userCreateMap);
        newPair.put(Constant.FIREBASE_PENDING_PAIR_TIME, createTime);
        pairedList.add(newPair);
        paired.put(Constant.FIREBASE_PENDING_PAIR, pairedList);
        return db.collection(Constant.FIREBASE_PENDING)
                .document(resId)
                .set(paired);


    }

//    public void createGroup(String resId, String uid, String createTime){
//
//        db.collection("pendings")
//                .document(resId)
//
//    }

    public DocumentReference getDocReferencesToPair(String resId){
        return db.collection(Constant.FIREBASE_PENDING).document(resId);
    }



}
