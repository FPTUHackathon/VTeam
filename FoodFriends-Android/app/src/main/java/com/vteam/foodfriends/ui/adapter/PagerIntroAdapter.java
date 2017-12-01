package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.*;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vteam.foodfriends.data.preferences.AppPreferences;

/**
 * Created by H2PhySicS on 11/30/2017.
 */

public class PagerIntroAdapter extends android.support.v4.view.PagerAdapter {
    private LayoutInflater mInflater;
    private int[] layouts;
    private Context mContext;

    public PagerIntroAdapter(Context context, int[] layouts){
        this.mContext = context;
        this.layouts = layouts;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(layouts[position], container, false);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
