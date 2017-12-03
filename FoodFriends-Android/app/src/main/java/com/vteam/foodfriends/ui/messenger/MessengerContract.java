package com.vteam.foodfriends.ui.messenger;

import com.vteam.foodfriends.data.model.TextMessage;
import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;
import com.vteam.foodfriends.ui.main.MainContract;

import java.util.List;
import java.util.Map;

/**
 * Created by phuongbka on 12/2/17.
 */

public class MessengerContract {
    public interface Presenter extends BasePresenter {
        void sendMessage(String boxId, TextMessage textMessage, List<Map<String, Object>> listMess);
        void getMessages();
    }

    public interface View extends BaseView<MessengerContract.Presenter> {

    }
}

