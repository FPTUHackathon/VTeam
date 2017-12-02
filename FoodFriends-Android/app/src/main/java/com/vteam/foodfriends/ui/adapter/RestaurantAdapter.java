package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.ui.base.BaseAdapter;
import com.vteam.foodfriends.ui.base.BaseViewHolder;

/**
 * Created by phuongbka on 12/1/17.
 */

public class RestaurantAdapter extends BaseAdapter<Restaurant> {
    public RestaurantAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getContentView() {
        return R.layout.item_home_fragment;
    }

    @Override
    public BaseViewHolder<Restaurant> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_fragment, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Restaurant> holder, int position) {
        Restaurant restaurant = mList.get(position);
        holder.bind(restaurant, position);
    }

    public class RestaurantViewHolder extends BaseViewHolder<Restaurant> {
        ImageView imgRestaurant;
        TextView txtName, txtAddress, txtTimeAvailable, txtStarRating;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            imgRestaurant = itemView.findViewById(R.id.iv_restaurant);
            txtAddress = itemView.findViewById(R.id.tv_address_restaurant);
            txtName = itemView.findViewById(R.id.tv_name_restaurant);
            txtTimeAvailable = itemView.findViewById(R.id.time_available);
            txtStarRating = itemView.findViewById(R.id.rating_star);
        }

        @Override
        public void bind(Restaurant restaurant, int position) {
//            Glide.with(mContext).load(restaurant.getImagelink())
//                    .into(imgRestaurant);
//            txtName.setText(restaurant.getName());
//            txtAddress.setText(restaurant.getAddress());
//            txtStarRating.setText(restaurant.getStar());
//            txtTimeAvailable.setText(restaurant.getTimeavailable());
        }
    }
}
