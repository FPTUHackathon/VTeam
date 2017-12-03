package com.vteam.foodfriends.ui.messenger;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.TextMessage;
import com.vteam.foodfriends.ui.adapter.MessengerAdapter;
import com.vteam.foodfriends.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MessengerActivity2Fragment extends BaseFragment implements MessengerContract.View {

    private MessengerContract.Presenter mPresenter;
    private List<TextMessage> mMessengerList;
    private MessengerAdapter mAdapter;
    @BindView(R.id.rv_message)
    RecyclerView mRecyclerView;

    public MessengerActivity2Fragment(){};

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
    }

    @Override
    public void initData() {
        mMessengerList = new ArrayList<>();
        for(int i = 0;i<15;i++){
//            TextMessage messenger = new TextMessage();
//            if(i%2==0){
//                messenger.setName("Me");
//                messenger.setMessage("Hello how are you? I'm find thank you");
//                messenger.setTime("11:30");
//            } else{
//                messenger.setName("Friend");
//                messenger.setMessage("Yup, I'm Ok");
//                messenger.setTime("11:30");
//            }
//            mMessengerList.add(messenger);
        }
        mAdapter.addAll(mMessengerList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
