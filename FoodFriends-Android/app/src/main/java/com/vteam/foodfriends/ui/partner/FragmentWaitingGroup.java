package com.vteam.foodfriends.ui.partner;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Group;
import com.vteam.foodfriends.ui.adapter.PartnerAdapterGroup;
import com.vteam.foodfriends.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by phuongbka on 12/1/17.
 */

public class FragmentWaitingGroup extends BaseFragment implements PartnerContract.View {
    private PartnerContract.Presenter mPresenter;
    private List<Group> mGroupList;
    private PartnerAdapterGroup mAdapter;
    @BindView(R.id.rv_partner_group)
    RecyclerView mRecyclerView;

    @Override
    public void setPresenter(PartnerContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_waiting_list_group;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {
        mAdapter = new PartnerAdapterGroup(mContext);
        mGroupList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Group group = new Group();
            group.setImage("hehe");
            group.setName("VTeam");
            group.setNumber("14");
            group.setTime("11h ngày mai");
            mGroupList.add(group);
        }
        mAdapter.addAll(mGroupList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
