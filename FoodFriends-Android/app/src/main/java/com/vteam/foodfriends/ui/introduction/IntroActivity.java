package com.vteam.foodfriends.ui.introduction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.preferences.AppPreferences;
import com.vteam.foodfriends.ui.adapter.PagerIntroAdapter;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.login.LoginActivity;

import butterknife.BindView;

public class IntroActivity extends BaseActivity implements IntroContract.View, ViewPager.OnPageChangeListener, View.OnClickListener{
    @BindView(R.id.pager_intro)
    ViewPager mPager;
    @BindView(R.id.layoutDots)
    LinearLayout mLayoutDots;
    @BindView(R.id.btn_next)
    Button mNext;
    @BindView(R.id.btn_skip)
    Button mSkip;

    private AppPreferences mPreferences;
    private IntroContract.Presenter mPresenter;
    private int[] layouts;
    private TextView[] dots;
    private PagerIntroAdapter mAdapter;

    @Override
    public int getContentView() {
        return R.layout.activity_intro;
    }

    @Override
    public void init() {
        mPreferences = new AppPreferences(this);
        mPresenter = new IntroPresenter(this);
        if (!mPreferences.isFirstTimeLaunch()){
            launchLoginScreen();
        }
        layouts = new int[]{
                R.layout.fragment_intro_screen1,
                R.layout.fragment_intro_screen2,
                R.layout.fragment_intro_screen3
        };

        addBottomDots(0);
        changeStatusBarColor();

        mAdapter = new PagerIntroAdapter(this, layouts);
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(this);

        mSkip.setOnClickListener(this);
        mNext.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void setPresenter(IntroContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void launchLoginScreen() {
        mPreferences.setFirstTimeLaunch(false);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void addBottomDots(int currentPage){
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        mLayoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            mLayoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);

    }

    private void changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        addBottomDots(position);
        if (position == layouts.length - 1){
            mNext.setText(getString(R.string.got_it));
            mSkip.setVisibility(View.GONE);
        } else {
            mNext.setText(getString(R.string.next));
            mSkip.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_skip: {
                launchLoginScreen();
                break;
            }
            case R.id.btn_next: {
                int current = mPager.getCurrentItem() + 1;
                if (current < layouts.length){
                    mPager.setCurrentItem(current);
                } else {
                    launchLoginScreen();
                }

                break;
            }
        }
    }
}
