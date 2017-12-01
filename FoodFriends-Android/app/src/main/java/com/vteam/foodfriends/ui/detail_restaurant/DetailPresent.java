package com.vteam.foodfriends.ui.detail_restaurant;

import android.content.Context;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by H2PhySicS on 12/1/2017.
 */

public class DetailPresent implements DetailContract.Presenter {
    private DetailContract.View mView;
    private Context mContext;

    public DetailPresent(Context context, DetailContract.View view) {
        this.mContext = context;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void getRestDetail() {
        mView.showComment(getFakeComments());
    }

    public List<Comment> getFakeComments(){
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            comments.add(new Comment(
                    mContext.getString(R.string.comment_title_example),
                    mContext.getString(R.string.comment_author_example),
                    mContext.getString(R.string.comment_time_example),
                    mContext.getString(R.string.comment_content_example),
                    3
            ));
        }
        return comments;
    }
}
