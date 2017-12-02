package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private Drawable mDrawable;

    public PagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new FragmentWaitingSingle();
                break;
            case 1:
                frag = new FragmentWaitingGroup();
                break;
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
