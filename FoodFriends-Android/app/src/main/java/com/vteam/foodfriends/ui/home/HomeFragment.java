package com.vteam.foodfriends.ui.home;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.ui.adapter.RestaurantAdapter;
import com.vteam.foodfriends.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.content.ContentValues.TAG;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    @BindView(R.id.newfeed)
    RecyclerView mNewfeed;
    List<Restaurant> mRestaurantList;

    private RestaurantAdapter mAdapter;
    private HomeContract.Presenter mPresenter;
    private DocumentReference docRef;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public HomeFragment() {
    }


    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        mAdapter = new RestaurantAdapter(getActivity());
        Log.d("init", " ");
        fetchData();
    }

    private void fetchData() {
        mRestaurantList = new ArrayList<>();
        db.collection("product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Restaurant restaurant = new Restaurant();
                                Log.d("hello", document.getId() + " => " + document.getData());
                                restaurant.setFoods((List<String>) document.getData().get("foods"));
                                restaurant.setStar(document.getString("rate"));
                                restaurant.setTimeavailable(document.getString("time"));
                                restaurant.setAddress(document.getString("address"));
                                restaurant.setName(document.getString("name"));
                                restaurant.setImagelink(document.getString("image"));
                                mRestaurantList.add(restaurant);
                            }
                        } else {
                            Log.d("hello", "Error getting documents: ", task.getException());
                        }
                        Log.d("size ", "" + mRestaurantList.size());
                        mAdapter.addAll(mRestaurantList);
                        mNewfeed.setAdapter(mAdapter);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("hello", "Error getting documents: " + e);
            }
        });
    }

    @Override
    public void initData() {
        mAdapter = new RestaurantAdapter(getActivity());
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
