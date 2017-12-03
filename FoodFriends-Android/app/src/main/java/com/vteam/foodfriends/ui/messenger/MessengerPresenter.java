package com.vteam.foodfriends.ui.messenger;

import android.content.Context;

import com.vteam.foodfriends.data.model.MessageFrom;
import com.vteam.foodfriends.data.model.TextMessage;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.preferences.AppPreferences;
import com.vteam.foodfriends.data.remote.FirebaseMessageService;
import com.vteam.foodfriends.ui.login.LoginPresenter;
import com.vteam.foodfriends.ui.main.MainContract;

import java.util.List;
import java.util.Map;

/**
 * Created by phuongbka on 12/2/17.
 */

public class MessengerPresenter implements MessengerContract.Presenter {
    private static final String LOG_TAG = MessengerPresenter.class.getSimpleName();
    private MessengerContract.View mView;
    private Context mContext;
    private FirebaseMessageService mMessageService;
    private AppPreferences mPreferences;

    public MessengerPresenter(Context context, MessengerContract.View mView) {
        this.mContext = context;
        this.mView = mView;
        mView.setPresenter(this);
        mMessageService = new FirebaseMessageService(mContext);
        mPreferences = new AppPreferences(mContext);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void sendMessage(String boxId, TextMessage textMessage, List<Map<String, Object>> listMess) {
        User user = mPreferences.getCurrentUser();
        textMessage.setMessageFrom(new MessageFrom(user.getAvatar(), user.getId(), user.getName()));

        mMessageService.setMessage(boxId, textMessage);
    }

    @Override
    public void getMessages() {

    }
}
