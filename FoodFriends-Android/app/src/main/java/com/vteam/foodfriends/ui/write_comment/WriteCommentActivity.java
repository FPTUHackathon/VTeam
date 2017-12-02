package com.vteam.foodfriends.ui.write_comment;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.base.BaseActivity;

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

    private WriteCommentContract.Presenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_write_comment;
    }

    @Override
    public void init() {

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
                break;
            }
            case R.id.btn_send: {
                break;
            }
        }
    }
}
