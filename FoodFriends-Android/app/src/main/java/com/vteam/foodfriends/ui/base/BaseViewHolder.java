package com.vteam.foodfriends.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by H2PhySicS on 11/28/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T t, int position);
}
