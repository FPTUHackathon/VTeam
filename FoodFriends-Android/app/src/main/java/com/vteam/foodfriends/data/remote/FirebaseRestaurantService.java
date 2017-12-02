package com.vteam.foodfriends.data.remote;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yukinohara on 12/2/17.
 */

public class FirebaseRestaurantService {
    private Context mContext;
    private FirebaseFirestore mDatabase;

    public  FirebaseRestaurantService(Context context){
        this.mContext = context;
        mDatabase = FirebaseFirestore.getInstance();
    }

    public Task<QuerySnapshot> getRestaurants(){
        return mDatabase.collection(Constant.FIREBASE_PRODUCT)
                .get();
    }

    public void updateRestaurant(String resId, int ranting){
        Map<String, Integer> product = new HashMap<>();
        product.put(Constant.FIREBASE_PRODUCT_AVERAGE_RATING, ranting);
        mDatabase.collection(Constant.FIREBASE_PRODUCT)
                .document(resId)
                .set(product);

    }
}
