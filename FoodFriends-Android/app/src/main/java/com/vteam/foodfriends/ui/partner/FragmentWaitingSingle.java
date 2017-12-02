package com.vteam.foodfriends.ui.partner;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Partner;
import com.vteam.foodfriends.ui.adapter.PartnerAdapterOne;
import com.vteam.foodfriends.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by phuongbka on 12/1/17.
 */

public class FragmentWaitingSingle extends BaseFragment implements PartnerContract.View {
    private PartnerContract.Presenter mPresenter;
    private List<Partner> mPartnerList;
    private PartnerAdapterOne mAdapter;
    @BindView(R.id.rv_partner_one)
    RecyclerView mRecyclerView;

    @Override
    public void setPresenter(PartnerContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_waiting_list_single;
    }

    private void fetchData() {

    }

    @Override
    public void initView(View view) {


    }

    @Override
    public void initData() {
        mAdapter = new PartnerAdapterOne(mContext);
        mPartnerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Partner partner = new Partner();
            partner.setAge("18");
            partner.setDistance("2km");
            partner.setImage("image");
            partner.setName("Thân Thị Thảo Vân");
            partner.setTime("11h sáng, ngày mai");
            mPartnerList.add(partner);
        }
        mAdapter.addAll(mPartnerList);
        mRecyclerView.setAdapter(mAdapter);

    }
}
