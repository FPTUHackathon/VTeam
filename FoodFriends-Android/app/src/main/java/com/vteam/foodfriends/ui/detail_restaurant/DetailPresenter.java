package com.vteam.foodfriends.ui.detail_restaurant;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.data.remote.FirebaseRestaurantService;
import com.vteam.foodfriends.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by H2PhySicS on 12/1/2017.
 */

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View mView;
    private Context mContext;
    private Restaurant mRes;
    private FirebaseRestaurantService mRestaurantService;

    public DetailPresenter(Context context, DetailContract.View view) {
        this.mContext = context;
        this.mView = view;
        mView.setPresenter(this);
        mRestaurantService = new FirebaseRestaurantService(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void getRestDetail(Intent i) {
        Restaurant restaurant = (Restaurant) i.getSerializableExtra(Constant.EXTRA_RESTAURANT);
        mRes = restaurant;
//        List<Map<String, Object>> list = restaurant.getComments();
//        List<Comment>  comments = new ArrayList<>();
//        for (Map<String, Object> m : list){
//            Comment comment = new Comment(
//                    (String) m.get("title"),
//                    (String) m.get("author"),
//                    (String) m.get("time"),
//                    (String) m.get("content"),
//                    (Long) m.get("rating")
//            );
//            comments.add(comment);
//        }

        mRestaurantService.getDocReferToWriteComment(mRes.getId())
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                        List<Map<String, Object>> list = (List<Map<String, Object>>) documentSnapshot.get(Constant.FIREBASE_PRODUCT_REVIEWS);

                        List<Comment>  comments = new ArrayList<>();
                        for (Map<String, Object> m : list){
                            Comment comment = new Comment(
                                    (String) m.get("title"),
                                    (String) m.get("author"),
                                    (String) m.get("time"),
                                    (String) m.get("content"),
                                    (Long) m.get("rating")
                            );
                            comments.add(comment);
                        }
                        mView.showComment(comments);
                    }
                });
        mView.showRestDetail(restaurant);

//        mView.showComment(comments);
    }

    @Override
    public void getResBeforeComment() {
        mView.openWriteComment(mRes);
    }


}
