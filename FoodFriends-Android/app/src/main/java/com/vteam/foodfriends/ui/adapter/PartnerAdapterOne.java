package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Partner;
import com.vteam.foodfriends.ui.base.BaseAdapter;
import com.vteam.foodfriends.ui.base.BaseViewHolder;

/**
 * Created by phuongbka on 12/1/17.
 */

public class PartnerAdapterOne extends BaseAdapter<Partner> {

    public PartnerAdapterOne(Context mContext) {
        super(mContext);
    }

    @Override
    public int getContentView() {
        return R.layout.item_fragment_waiting_list_single;
    }

    @Override
    public BaseViewHolder<Partner> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(getContentView(), parent, false);
        return new PartnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Partner> holder, int position) {
        Log.d("view holder", " " + position);
        Partner partner = mList.get(position);
        holder.bind(partner,position);
    }

    public class PartnerViewHolder extends BaseViewHolder<Partner> {
        ImageView mAvatar;
        TextView mName, mAge, mTime, mDistance;

        public PartnerViewHolder(View itemView) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.avatar_single);
            mName = itemView.findViewById(R.id.tv_name_user_single);
            mAge = itemView.findViewById(R.id.age_single);
            mTime = itemView.findViewById(R.id.tv_time_single);
            mDistance = itemView.findViewById(R.id.tv_distance_single);
        }

        @Override
        public void bind(Partner partner, int position) {

            Glide.with(mContext).load(R.drawable.avatar)
                    .into(mAvatar);
            mName.setText(partner.getName());
            mAge.setText(partner.getAge());
            mTime.setText(partner.getTime());
            mDistance.setText(partner.getDistance());
        }
    }
}
