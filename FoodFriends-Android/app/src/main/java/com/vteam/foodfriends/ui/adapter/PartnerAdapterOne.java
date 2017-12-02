package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
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
    private OnItemClickListener onItemClickListener;
    View view;

    public PartnerAdapterOne(Context mContext) {
        super(mContext);
    }

    @Override
    public int getContentView() {
        return R.layout.item_fragment_waiting_list_single;
    }

    @Override
    public BaseViewHolder<Partner> onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(getContentView(), parent, false);
        return new PartnerViewHolder(view);
    }

    public void setOnItemClick(PartnerAdapterOne.OnItemClickListener onClickListener) {
        this.onItemClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Partner> holder, int position) {
        Log.d("view holder", " " + position);
        Partner partner = mList.get(position);
        holder.bind(partner,position);
    }

    public class PartnerViewHolder extends BaseViewHolder<Partner> implements View.OnClickListener  {
        ImageView mAvatar,mMessengerNow;
        TextView mName, mAge, mTime, mDistance;

        public PartnerViewHolder(View itemView) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.avatar_single);
            mName = itemView.findViewById(R.id.tv_name_user_single);
            mAge = itemView.findViewById(R.id.age_single);
            mTime = itemView.findViewById(R.id.tv_time_single);
            mDistance = itemView.findViewById(R.id.tv_distance_single);
            mMessengerNow = itemView.findViewById(R.id.messenger_now);
            itemView.getRootView().setOnClickListener(this);
            mMessengerNow.setOnClickListener(this);
            mAvatar.setOnClickListener(this);
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

        @Override
        public void onClick(View view) {
            onItemClickListener.onClick(getAdapterPosition(),view);
        }

    }

    public interface OnItemClickListener {
        void onClick(int position, View view);
    }
}
