package com.vteam.foodfriends.ui.messenger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ServerValue;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.TextMessage;
import com.vteam.foodfriends.ui.adapter.MessengerAdapter;
import com.vteam.foodfriends.ui.base.BaseFragment;
import com.vteam.foodfriends.utils.Constant;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MessengerActivity2Fragment extends BaseFragment implements MessengerContract.View, View.OnClickListener {
    private static final String LOG_TAG = MessengerActivity2Fragment.class.getSimpleName();

    private MessengerContract.Presenter mPresenter;
    private List<TextMessage> mMessengerList;
    private MessengerAdapter mAdapter;
    @BindView(R.id.rv_message)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_message)
    TextView mMessage;
    @BindView(R.id.btn_send)
    ImageView mSend;

    private String type;
    private String boxId;

    public MessengerActivity2Fragment(){}

    @Override
    public void setPresenter(MessengerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_messenger;
    }

    @Override
    public void initView(View view) {
        mAdapter = new MessengerAdapter(getActivity());
        mSend.setOnClickListener(this);
    }

    @Override
    public void initData() {
        Intent intent = getActivity().getIntent();
        boxId = intent.getStringExtra(Constant.EXTRA_BOX_ID);
        mMessengerList = new ArrayList<>();
        mPresenter = new MessengerPresenter(mContext, this);

        mAdapter.addAll(mMessengerList);
        mRecyclerView.setAdapter(mAdapter);
        type = "TEXT";

    }

    @Override
    public void onClick(View view) {
        String content = mMessage.getText().toString();
        TextMessage textMessage = new TextMessage(content, type);
        mPresenter.sendMessage(boxId, textMessage, new ArrayList<Map<String, Object>>());
    }
}
