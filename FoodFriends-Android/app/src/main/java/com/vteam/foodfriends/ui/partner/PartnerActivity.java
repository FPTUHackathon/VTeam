package com.vteam.foodfriends.ui.partner;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Partner;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.main.MainContract;

import java.util.ArrayList;
import java.util.List;

public class PartnerActivity extends BaseActivity implements PartnerContract.View, View.OnClickListener {
    private PartnerContract.Presenter mPresenter;
    private ViewPager pager;
    private TabLayout tabLayout;


    @Override
    public int getContentView() {
        return R.layout.activity_partner;
    }

    @Override
    public void init() {
        addControl();
    }


    private void addControl() {
        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab);
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new com.vteam.foodfriends.ui.adapter.PagerAdapter(this, manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setPresenter(PartnerContract.Presenter presenter) {
    }
}
