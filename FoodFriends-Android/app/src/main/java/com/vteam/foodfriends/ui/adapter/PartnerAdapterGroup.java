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
import com.vteam.foodfriends.data.model.Group;
import com.vteam.foodfriends.data.model.Partner;
import com.vteam.foodfriends.ui.base.BaseAdapter;
import com.vteam.foodfriends.ui.base.BaseViewHolder;

/**
 * Created by phuongbka on 12/2/17.
 */

public class PartnerAdapterGroup extends BaseAdapter<Group> {
    public PartnerAdapterGroup(Context mContext) {
        super(mContext);
    }
    private OnItemClickListener onClickListener;
    View view;

    @Override
    public int getContentView() {
        return R.layout.item_fragment_waiting_list_group;
    }

    @Override
    public BaseViewHolder<Group> onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(getContentView(), parent, false);
        return new PartnerAdapterGroup.GroupViewHolder(view);
    }

    public void setOnItemClick(OnItemClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Group> holder, int position) {
        Log.d("view holder", " " + position);
        Group group = mList.get(position);
        holder.bind(group ,position);
    }

    public class GroupViewHolder extends BaseViewHolder<Group> implements View.OnClickListener{
        ImageView mAvatar;
        TextView mName, mTime;

        public GroupViewHolder(View itemView) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.avatar);
            mName = itemView.findViewById(R.id.tv_name_user);
            mTime = itemView.findViewById(R.id.tv_time);
            itemView.getRootView().setOnClickListener(this);
            mAvatar.setOnClickListener(this);
        }

        @Override
        public void bind(Group group, int position) {
            Glide.with(mContext).load(R.drawable.avatar)
                    .into(mAvatar);
            mName.setText(group.getName());
            mTime.setText(group.getTime());
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(getAdapterPosition(),view);

        }
    }

    public interface OnItemClickListener {
        void onClick(int position,View view);
    }


}
