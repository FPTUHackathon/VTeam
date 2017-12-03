package com.vteam.foodfriends.data.remote;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;
import com.vteam.foodfriends.utils.Constant;

/**
 * Created by yukinohara on 12/3/17.
 */

public class FirebaseMessageService {
    private static final String LOG_TAG = FirebaseMessageService.class.getSimpleName();
    private Context mContext;
    private FirebaseFirestore db;

    public FirebaseMessageService(Context context){
        this.mContext = context;
        db = FirebaseFirestore.getInstance();
    }

    public void getMessagePair(String uid, String fid){
//        db.collection(Constant.FIREBASE_MESSAGE + "/" + uid)
//                .whereEqualTo()
    }
}
