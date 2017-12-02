package com.vteam.foodfriends.ui.write_comment;

import android.content.Context;

import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.remote.FirebaseRestaurantService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yukinohara on 12/2/17.
 */

public class WriteCommentPresenter implements WriteCommentContract.Presenter {
    private WriteCommentContract.View mView;
    private Context mContext;
    private FirebaseRestaurantService mDatabase;

    public WriteCommentPresenter(Context context, WriteCommentContract.View view){
        this.mContext = context;
        this.mView = view;
        mView.setPresenter(this);
        mDatabase = new FirebaseRestaurantService(mContext);

    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void writeComment(String resId, List<Map<String, Object>> list, String title, String content, long rating, User user) {
        Date date = new Date();
        Comment comment = new Comment(title, user.getName(), date.toString(), content, rating);
        mDatabase.writeComment(resId, list, comment);
    }
}