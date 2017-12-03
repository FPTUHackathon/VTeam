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
import com.vteam.foodfriends.data.model.Pair;
import com.vteam.foodfriends.data.model.Partner;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.ui.base.BaseAdapter;
import com.vteam.foodfriends.ui.base.BaseViewHolder;
import com.vteam.foodfriends.utils.AppUtils;

/**
 * Created by phuongbka on 12/1/17.
 */

public class PartnerAdapterOne extends BaseAdapter<Pair> {
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
    public BaseViewHolder<Pair> onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(getContentView(), parent, false);
        return new PartnerViewHolder(view);
    }

    public void setOnItemClick(PartnerAdapterOne.OnItemClickListener onClickListener) {
        this.onItemClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Pair> holder, int position) {
        Log.d("view holder", " " + position);
//        Partner partner = mList.get(position);
        holder.bind(mList.get(position),position);
    }

    public class PartnerViewHolder extends BaseViewHolder<Pair> implements View.OnClickListener  {
        ImageView mAvatar,mMessengerNow, mGender;
        TextView mName, mAge, mTime, mDistance;

        public PartnerViewHolder(View itemView) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.avatar_single);
            mName = itemView.findViewById(R.id.tv_name_user_single);
            mAge = itemView.findViewById(R.id.age_single);
            mTime = itemView.findViewById(R.id.tv_time_single);
            mDistance = itemView.findViewById(R.id.tv_distance_single);
            mMessengerNow = itemView.findViewById(R.id.messenger_now);
            mGender = itemView.findViewById(R.id.male);
            itemView.getRootView().setOnClickListener(this);
            mMessengerNow.setOnClickListener(this);
            mAvatar.setOnClickListener(this);
        }

        @Override
        public void bind(Pair pair, int position) {
            String time = pair.getTime();
            User user = pair.getUser();
            if (user.getAvatar() == null){
//                Glide.with(mContext).load()
            } else {
                Glide.with(mContext).load(user.getAvatar()).into(mAvatar);
            }
            if (user.isMale()){
                Glide.with(mContext)
                        .load(R.drawable.male_orange).into(mGender);
            } else {
                Glide.with(mContext)
                        .load(R.drawable.female_orange).into(mGender);
            }
            mName.setText(user.getName());
            mAge.setText(AppUtils.getAge(user.getDob()) + "");
            mTime.setText(time);


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
