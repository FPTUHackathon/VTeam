package com.vteam.foodfriends.ui.detail_restaurant;

import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.ui.base.BasePresenter;
import com.vteam.foodfriends.ui.base.BaseView;

import java.util.List;

/**
 * Created by H2PhySicS on 12/1/2017.
 */

public class DetailContract {
    public interface Presenter extends BasePresenter{
        void getRestDetail();
    }

    public interface View extends BaseView<Presenter>{
        void showComment(List<Comment> comments);
        void showRestDetail();
    }
}