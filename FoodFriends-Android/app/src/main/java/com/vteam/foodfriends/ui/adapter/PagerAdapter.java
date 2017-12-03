package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.partner.FragmentWaitingSingle;
import com.vteam.foodfriends.ui.partner.FragmentWaitingGroup;
import com.vteam.foodfriends.utils.Constant;

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private Drawable mDrawable;
    private String resId;

    public PagerAdapter(Context context,FragmentManager fm, String resId) {
        super(fm);
        this.mContext = context;
        this.resId = resId;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        Bundle bundle = new Bundle();
        bundle.putString(Constant.EXTRA_RESTAURANT_ID, resId);
        switch (position) {
            case 0:{
                frag = new FragmentWaitingSingle();
                frag.setArguments(bundle);
                break;
            }

            case 1:{
                frag = new FragmentWaitingGroup();
                frag.setArguments(bundle);
                break;
            }

        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                mDrawable = mContext.getResources().getDrawable(R.drawable.user);
                break;
            case 1:
                mDrawable = mContext.getResources().getDrawable(R.drawable.group);
                break;
            default:
                break;
        }
        SpannableStringBuilder sb = new SpannableStringBuilder("   "); // space added before text for convenience
        try {
            mDrawable.setBounds(5, 5, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
            ImageSpan span = new ImageSpan(mDrawable, DynamicDrawableSpan.ALIGN_BASELINE);
            sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (Exception e) {
        }


        return sb;
    }
}
