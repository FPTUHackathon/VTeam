package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.TextMessage;
import com.vteam.foodfriends.ui.base.BaseAdapter;
import com.vteam.foodfriends.ui.base.BaseViewHolder;

/**
 * Created by phuongbka on 12/2/17.
 */

public class MessengerAdapter extends BaseAdapter<TextMessage> {
    View view;
    private final int SELF = 10;
    private final int FRIEND = 11;

    public MessengerAdapter(Context mContext){super(mContext);}

    @Override
    public int getContentView() {
        return R.layout.item_message_left;
    }

    @Override
    public BaseViewHolder<TextMessage> onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == SELF){
            view = LayoutInflater.from(mContext).inflate(getContentView(),parent,false);
        } else{
            view = LayoutInflater.from(mContext).inflate(R.layout.item_messenger_right,parent,false);
        }
        return new MessengerViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        TextMessage messenger = mList.get(position);
//        if(messenger.getName()=="Me"){
//            return SELF;
//        } else{
//            return FRIEND;
//        }
        return SELF;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<TextMessage> holder, int position) {
        TextMessage messenger = mList.get(position);
        holder.bind(messenger, position);
    }

    public class MessengerViewHolder extends BaseViewHolder<TextMessage>{
        ImageView mAvatar;
        TextView mMessage, mTime;

        public MessengerViewHolder(View itemView){
            super(itemView);
            mAvatar = itemView.findViewById(R.id.avatar);
            mMessage = itemView.findViewById(R.id.tv_message);
            mTime = itemView.findViewById(R.id.tv_time);
        }

        @Override
        public void bind(TextMessage messenger, int position) {
            Glide.with(mContext).load(R.drawable.avatar).into(mAvatar);
//            mMessage.setText(messenger.getMessage());
//            mTime.setText(messenger.getTime());
        }
    }
}
