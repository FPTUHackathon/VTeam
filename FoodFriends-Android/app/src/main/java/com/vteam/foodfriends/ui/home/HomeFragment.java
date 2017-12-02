package com.vteam.foodfriends.ui.home;

import android.content.Intent;
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
import com.vteam.foodfriends.data.remote.FirebaseRestaurantService;
import com.vteam.foodfriends.ui.adapter.RestaurantAdapter;
import com.vteam.foodfriends.ui.base.BaseFragment;
import com.vteam.foodfriends.ui.detail_restaurant.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.content.ContentValues.TAG;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View, RestaurantAdapter.OnItemClickListener {
    @BindView(R.id.newfeed)
    RecyclerView mNewfeed;
    List<Restaurant> mRestaurantList;

    private RestaurantAdapter mAdapter;
    private HomeContract.Presenter mPresenter;

    public HomeFragment() {
    }


    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        mAdapter = new RestaurantAdapter(getActivity());
    }



    @Override
    public void initData() {
        mAdapter = new RestaurantAdapter(getActivity());
        mPresenter = new HomePresenter(mContext, this, new FirebaseRestaurantService(mContext));
        mPresenter.fetchRestaurants();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showRestaurants(List<Restaurant> list) {
        mAdapter.addAll(list);
        mNewfeed.setAdapter(mAdapter);
    }

    @Override
    public void onClick(int position) {
        Restaurant restaurant = mRestaurantList.get(position);

//        Intent intent = new Intent(mContext, DetailActivity.class);
//        intent.putExtra()

    }
}
