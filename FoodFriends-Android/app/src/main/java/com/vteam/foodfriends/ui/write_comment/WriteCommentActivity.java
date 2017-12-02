package com.vteam.foodfriends.ui.write_comment;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.utils.Constant;

import butterknife.BindView;

public class WriteCommentActivity extends BaseActivity implements WriteCommentContract.View, View.OnClickListener{
    private static final String LOG_TAG = WriteCommentActivity.class.getSimpleName();
    @BindView(R.id.btn_cancel)
    Button mCancel;
    @BindView(R.id.btn_send)
    Button mSend;
    @BindView(R.id.tv_name)
    TextView mName;
    @BindView(R.id.tv_location)
    TextView mLocation;
    @BindView(R.id.edt_title)
    TextInputEditText mTitle;
    @BindView(R.id.edt_content)
    TextInputEditText mContent;
    @BindView(R.id.rating)
    RatingBar mRating;

    private WriteCommentContract.Presenter mPresenter;
    private Restaurant mRestaurant;

    @Override
    public int getContentView() {
        return R.layout.activity_write_comment;
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        mRestaurant = (Restaurant) intent.getSerializableExtra(Constant.EXTRA_RESTAURANT);

        mName.setText(mRestaurant.getName());
        mLocation.setText(mRestaurant.getAddress());
        mPresenter = new WriteCommentPresenter(this, this);

    }

    @Override
    public void setPresenter(WriteCommentContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_cancel: {
                finish();
                break;
            }
            case R.id.btn_send: {
                if (TextUtils.isEmpty(mContent.getText()) || mRating.getNumStars() <= 0){
                    return;
                }

                mPresenter.writeComment(mRestaurant.getId(), mRestaurant.getComments(), mTitle.getText().toString(), mContent.getText().toString(), (long) mRating.getNumStars());
                break;
            }
        }
    }
}
