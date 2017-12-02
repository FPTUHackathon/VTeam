package com.vteam.foodfriends.data.remote;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.utils.Constant;

import java.util.HashMap;
import java.util.List;
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
        Map<String, Object> product = new HashMap<>();
        product.put(Constant.FIREBASE_PRODUCT_AVERAGE_RATING, ranting);
        mDatabase.collection(Constant.FIREBASE_PRODUCT)
                .document(resId)
                .update(product);

    }

    public void writeComment(String resId, List<Map<String, Object>> list, Comment comment){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> commentElement = new HashMap<>();
        commentElement.put("title", comment.getTitle());
        commentElement.put("author", comment.getAuthor());
        commentElement.put("time", comment.getTime());
        commentElement.put("content", comment.getContent());
        commentElement.put("rating", comment.getRating());
        list.add(commentElement);
        map.put(Constant.FIREBASE_PRODUCT_REVIEWS, list);
        mDatabase.collection(Constant.FIREBASE_PRODUCT)
                .document(resId)
                .update(map);
    }
}
