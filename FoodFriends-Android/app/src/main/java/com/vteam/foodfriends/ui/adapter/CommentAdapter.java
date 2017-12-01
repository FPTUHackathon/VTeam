package com.vteam.foodfriends.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.ui.base.BaseAdapter;
import com.vteam.foodfriends.ui.base.BaseViewHolder;

/**
 * Created by H2PhySicS on 12/1/2017.
 */

public class CommentAdapter extends BaseAdapter<Comment> {

    public CommentAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getContentView() {
        return R.layout.item_comment;
    }

    @Override
    public BaseViewHolder<Comment> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(getContentView(), parent, false);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Comment> holder, int position) {
        holder.bind(mList.get(position), position);
    }

    public class CommentViewHolder extends BaseViewHolder<Comment>{
        private TextView mTitle, mAuthor, mTime, mContent;
        private RatingBar mUserRating;

        public CommentViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tv_comment_title);
            mAuthor = itemView.findViewById(R.id.tv_comment_author);
            mTime = itemView.findViewById(R.id.tv_comment_time);
            mContent = itemView.findViewById(R.id.tv_comment_content);
            mUserRating = itemView.findViewById(R.id.rating_other_user);

        }

        @Override
        public void bind(Comment comment, int position) {
            mTitle.setText(comment.getTitle());
            mAuthor.setText(comment.getAuthor());
            mTime.setText(comment.getTime());
            mContent.setText(comment.getContent());
            mUserRating.setNumStars(comment.getRating());
        }
    }
}
