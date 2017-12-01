package com.vteam.foodfriends.ui.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.adapter.PagerAdapter;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.home.HomeFragment;
import com.vteam.foodfriends.ui.login.LoginContract;
import com.vteam.foodfriends.utils.ScreenManager;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View, View.OnClickListener {
    @BindView(R.id.space)
    SpaceNavigationView mSpaceNavigationView;
    @BindView(R.id.search_view)
    SearchView searchView;
    private LoginContract.Presenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        ScreenManager.openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.rl_content);
        spaceNavigationView();
        searchViewConfig();
        mSpaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                if (itemIndex == 0) {
                    Log.d("item clikc", "fdsaf");
                    ScreenManager.openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.rl_content);
                } else if (itemIndex == 1) {
                    ScreenManager.openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.rl_content);
                } else if (itemIndex == 2) {
                    ScreenManager.openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.rl_content);
                } else if (itemIndex == 3) {
                    ScreenManager.openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.main);
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });

    }

    private void searchViewConfig() {
        searchView.onActionViewExpanded();
        searchView.setQueryHint("Thông tin địa điểm, dịch vụ");
        searchView.setIconified(false);
        searchView.clearFocus();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {


    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void spaceNavigationView() {
        mSpaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.home));
        mSpaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.heart));
        mSpaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.bell));
        mSpaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.menu));
        mSpaceNavigationView.changeCenterButtonIcon(R.drawable.ic_plus);
    }

}
