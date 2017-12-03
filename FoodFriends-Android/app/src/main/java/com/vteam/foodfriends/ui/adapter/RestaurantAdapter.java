package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
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
    private OnItemClickListener mListener;

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

    public class RestaurantViewHolder extends BaseViewHolder<Restaurant> implements View.OnClickListener{
        ImageView imgRestaurant;
        TextView txtDiscount, txtName, txtAddress, txtTimeAvailable, txtStarRating;
        CardView mCardView;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view);
            imgRestaurant = itemView.findViewById(R.id.iv_restaurant);
            txtDiscount = itemView.findViewById(R.id.discount_number);
            txtAddress = itemView.findViewById(R.id.tv_address_restaurant);
            txtName = itemView.findViewById(R.id.tv_name_restaurant);
            txtTimeAvailable = itemView.findViewById(R.id.time_available);
            txtStarRating = itemView.findViewById(R.id.rating_star);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void bind(Restaurant restaurant, int position) {
//            Glide.with(mContext).load(restaurant.getPhotoUrl()).into(imgRestaurant);
            txtDiscount.setText(restaurant.getDiscounts()[1] + "%");
            txtAddress.setText(restaurant.getAddress());
            txtName.setText(restaurant.getName());
            txtStarRating.setText(restaurant.getRating() + "");

        }

        @Override
        public void onClick(View view) {
            mListener.onClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public Restaurant get(int position){
        return mList.get(position);
    }
}
