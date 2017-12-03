package com.vteam.foodfriends.ui.partner;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Pair;
import com.vteam.foodfriends.data.model.Partner;
import com.vteam.foodfriends.ui.adapter.PartnerAdapterOne;
import com.vteam.foodfriends.ui.base.BaseFragment;
import com.vteam.foodfriends.ui.messenger.MessengerActivity2;
import com.vteam.foodfriends.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by phuongbka on 12/1/17.
 */

public class FragmentWaitingSingle extends BaseFragment implements WaitingSingleContract.View, View.OnClickListener, PartnerAdapterOne.OnItemClickListener {

    private List<Partner> mPartnerList;
    private PartnerAdapterOne mAdapter;
    @BindView(R.id.rv_partner_one)
    RecyclerView mRecyclerView;
    @BindView(R.id.btn_skip)
    Button mSkip;

    private List<Map<String, String>> mPairs;
    private String uid;
    private String resId;
    private FragmentWaitingSingle mInstace;
    private WaitingSingleContract.Presenter mPresenter;

    public FragmentWaitingSingle(){

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_waiting_list_single;
    }


    @Override
    public void initView(View view) {


    }

    @Override
    public void initData() {
        mAdapter = new PartnerAdapterOne(mContext);
        mPresenter = new WaitingSinglePresenter(mContext, this);
        Bundle bundle = getArguments();
        resId = bundle.getString(Constant.EXTRA_RESTAURANT_ID);
        mPairs = new ArrayList<>();

//        mAdapter.addAll(mPairs);
//        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClick(this);
        mSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ReserveDialog reserveDialog = new ReserveDialog(mContext, new ReserveDialog.OnClick() {
            @Override
            public void onOkClick(String time) {
                mPresenter.createPair(resId, mPairs, time);
            }
        });
        reserveDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        reserveDialog.show();
    }

    @Override
    public void onClick(int position, View view) {
        switch (view.getId()){
            case R.id.avatar_single:
                showDialog();
                break;
            case R.id.messenger_now:
                newActivity();
                break;
        }
    }

    private void newActivity() {
        Intent intent = new Intent(mContext, MessengerActivity2.class);
        startActivity(intent);
    }

    private void showDialog() {
        Dialog dialog = new Dialog(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View info_group = inflater.inflate(R.layout.layout_info_partner, null);

        dialog.setContentView(info_group);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public void setPresenter(WaitingSingleContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
