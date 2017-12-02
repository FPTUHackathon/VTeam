package com.vteam.foodfriends.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.data.remote.FirebaseRestaurantService;
import com.vteam.foodfriends.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public class HomePresenter implements HomeContract.Presenter{
    private static final String LOG_TAG = HomePresenter.class.getSimpleName();
    private HomeContract.View mView;
    private Context mContext;
    private FirebaseRestaurantService mRestaurantRepository;

    public HomePresenter(Context context, HomeContract.View view, FirebaseRestaurantService restaurantService) {
        this.mContext = context;
        this.mView = view;
        this.mRestaurantRepository = restaurantService;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void fetchRestaurants() {
        final List<Restaurant> restaurants = new ArrayList<>();
        Task<QuerySnapshot> task = mRestaurantRepository.getRestaurants();
        task.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot documentSnapshot : task.getResult()){
                        String id = documentSnapshot.getId();
                        String address = documentSnapshot.getString(Constant.FIREBASE_PRODUCT_ADRESS);
                        long rating = (Long) documentSnapshot.get(Constant.FIREBASE_PRODUCT_AVERAGE_RATING);
                        double lat = documentSnapshot.getDouble(Constant.FIREBASE_PRODUCT_LAT);
                        double lon = documentSnapshot.getDouble(Constant.FIREBASE_PRODUCT_LON);
                        String name = documentSnapshot.getString(Constant.FIREBASE_PRODUCT_NAME);
                        Map<String, Long> offers = (Map<String, Long>) documentSnapshot.get(Constant.FIREBASE_PRODUCT_DISCOUNT);
                        long[] discounts = new long[]{offers.get("Group"), offers.get("Pair")};
                        String photoUrl = documentSnapshot.getString(Constant.FIREBASE_PRODUCT_PHOTOURL);
                        String cuisineUrl = documentSnapshot.getString(Constant.FIREBASE_PRODUCT_CUISINE_URL);
                        String openTime = documentSnapshot.getString(Constant.FIREBASE_PRODUCT_TIME_OPEN);
                        String closeTime = documentSnapshot.getString(Constant.FIREBASE_PRODUCT_TIME_CLOSE);
                        List<Map<String, Object>> list = (List<Map<String, Object>>) documentSnapshot.get(Constant.FIREBASE_PRODUCT_REVIEWS);

                        Restaurant restaurant = new Restaurant(
                                id,
                                address,
                                name,
                                photoUrl,
                                openTime,
                                closeTime,
                                list.size(),
                                rating,
                                discounts,
                                lat,
                                lon,
                                list

                        );
                        restaurants.add(restaurant);
                    }

                    mView.showRestaurants(restaurants);

                } else {
                    Log.e(LOG_TAG, "Failed");
                }
            }
        });

    }
}
