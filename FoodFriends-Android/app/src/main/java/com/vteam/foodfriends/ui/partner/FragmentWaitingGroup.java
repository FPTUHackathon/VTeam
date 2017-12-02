package com.vteam.foodfriends.ui.partner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
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

public class FragmentWaitingGroup extends BaseFragment implements PartnerContract.View, View.OnClickListener, PartnerAdapterGroup.OnItemClickListener {
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
        mAdapter.setOnItemClick(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int position, View view) {
        Log.d("FragmentGroup", position + "");
        switch (view.getId()) {
            case R.id.avatar:
                showDialog();
                break;
        }

    }

    private void showDialog() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        Dialog dialog = new Dialog(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View info_group = inflater.inflate(R.layout.layout_info_group, null);

        dialog.setContentView(info_group);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
