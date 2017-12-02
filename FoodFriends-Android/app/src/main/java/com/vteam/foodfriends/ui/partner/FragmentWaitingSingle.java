package com.vteam.foodfriends.ui.partner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
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

public class FragmentWaitingSingle extends BaseFragment implements PartnerContract.View, View.OnClickListener, PartnerAdapterOne.OnItemClickListener {
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
        mAdapter.setOnItemClick(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int position, View view) {
        switch (view.getId()){
            case R.id.avatar_single:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        Dialog dialog = new Dialog(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View info_group = inflater.inflate(R.layout.layout_info_partner, null);

        dialog.setContentView(info_group);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
