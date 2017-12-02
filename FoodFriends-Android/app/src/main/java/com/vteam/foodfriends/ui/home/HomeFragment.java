package com.vteam.foodfriends.ui.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Data;
import com.vteam.foodfriends.data.model.Image;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.data.remote.FirebaseRestaurantService;
import com.vteam.foodfriends.data.remote.api.Client;
import com.vteam.foodfriends.data.remote.api.GetAllImage;
import com.vteam.foodfriends.ui.adapter.RestaurantAdapter;
import com.vteam.foodfriends.ui.base.BaseFragment;
import com.vteam.foodfriends.ui.detail_restaurant.DetailActivity;
import com.vteam.foodfriends.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View, RestaurantAdapter.OnItemClickListener {
    @BindView(R.id.newfeed)
    RecyclerView mNewfeed;
    List<Restaurant> mRestaurantList;

    private RestaurantAdapter mAdapter;
    private HomeContract.Presenter mPresenter;
    Image image;

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
        getImageRetrofit();
        mAdapter = new RestaurantAdapter(getActivity());
        mPresenter = new HomePresenter(mContext, this, new FirebaseRestaurantService(mContext));
        mPresenter.fetchRestaurants();
        mAdapter.setOnItemClickListener(this);
    }

    private void getImageRetrofit() {
        image = new Image();

        Log.d("getImageRetrofit", "getImageRetrofit: sending request");

        GetAllImage getAllImageModel = Client.getInstance(mContext).create(GetAllImage.class);
        getAllImageModel.getAllImage().enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call, Response<Image> response) {
                Log.d("response"," "+ response.body());
                Log.d("onResponse", "onResponse: ahihi");
                image = response.body();
            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {

            }
        });
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
        Restaurant restaurant = mAdapter.get(position);

        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(Constant.EXTRA_RESTAURANT, restaurant);
        startActivity(intent);

    }
}
