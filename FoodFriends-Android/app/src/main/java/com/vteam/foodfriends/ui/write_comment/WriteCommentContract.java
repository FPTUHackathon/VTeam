package com.vteam.foodfriends.ui.write_comment;

import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by yukinohara on 12/2/17.
 */

public class WriteCommentContract {
    public interface Presenter extends BasePresenter{
        void writeComment(String resId, List<Map<String, Object>> list, String title, String content, long rating);
    }

    public interface View extends BaseView<Presenter>{

    }
}
