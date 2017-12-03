package com.vteam.foodfriends.ui.partner;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.vteam.foodfriends.data.model.Pair;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.preferences.AppPreferences;
import com.vteam.foodfriends.data.remote.FirebasePendingService;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.utils.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yukinohara on 12/2/17.
 */

public class WaitingSinglePresenter implements WaitingSingleContract.Presenter {
    private WaitingSingleContract.View mView;
    private Context mContext;
    private FirebasePendingService mPendingService;
    private FirebaseUserService mUserService;
    private AppPreferences mPreferences;

    public WaitingSinglePresenter(Context context, WaitingSingleContract.View mView) {
        this.mContext = context;
        this.mView = mView;
        mView.setPresenter(this);
        mPendingService = new FirebasePendingService(mContext);
        mUserService = new FirebaseUserService(mContext);
        mPreferences = new AppPreferences(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void createPair(String resId, List<Map<String, Object>> list, String time) {
        User user = mPreferences.getCurrentUser();
        mPendingService.createPair(resId, list, user, time);
    }

    @Override
    public void getPairs(String resId) {
        mPendingService.getPairs(resId)
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        List<Map<String, Object>> pairs = (List<Map<String, Object>>) documentSnapshot.get(Constant.FIREBASE_PENDING_PAIR);
                        List<Pair> list = new ArrayList<>();
                        for (Map<String, Object> m : pairs){
                            String time = (String) m.get(Constant.FIREBASE_PENDING_PAIR_TIME);
                            Map<String, Object> userMap = (Map<String, Object>) m.get(Constant.FIREBASE_PENDING_PAIR_USER_CREATE);
                            String uid = (String) userMap.get(Constant.FIREBASE_USER_ID);
                            String email = (String) userMap.get(Constant.FIREBASE_USER_EMAIL);
                            String username = (String) userMap.get(Constant.FIREBASE_USER_USERNAME);
                            String phone = (String) userMap.get(Constant.FIREBASE_USER_PHONE);
                            String dob = (String) userMap.get(Constant.FIREBASE_USER_DOB);
                            boolean isMale = (Boolean) userMap.get(Constant.FIREBASE_USER_GENDER);
                            User user = new User(
                                    uid,
                                    email,
                                    username,
                                    phone,
                                    dob,
                                    isMale
                            );
                            Pair pair = new Pair(time, user);
                            list.add(pair);

                        }
                        mView.showPairs(pairs, list);
                    }
                });
    }
}
