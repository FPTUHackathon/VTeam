package com.vteam.foodfriends.ui.detail_restaurant;

import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.ui.adapter.CommentAdapter;
import com.vteam.foodfriends.ui.base.BaseActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DetailActivity extends BaseActivity implements DetailContract.View,
        AppBarLayout.OnOffsetChangedListener{
    private static final String LOG_TAG = DetailActivity.class.getSimpleName();
    @BindView(R.id.gallery_layout)
    GridLayout mGallery;
    @BindView(R.id.gallery_detail_layout)
    GridLayout mGalleryDetail;
    @BindView(R.id.main_image)
    ImageView mMainImage;
    @BindView(R.id.detail_image_1)
    ImageView mDetailImage1;
    @BindView(R.id.detail_image_2)
    ImageView mDetailImage2;
    @BindView(R.id.detail_image_3)
    ImageView mDetailImage3;
    @BindView(R.id.detail_image_4)
    ImageView mDetailImage4;
    @BindView(R.id.appbar_detail_food)
    AppBarLayout mAppbar;
    @BindView(R.id.header)
    ImageView mHeader;
    @BindView(R.id.toolbar_detail)
    Toolbar mToolbarDetail;
    @BindView(R.id.tv_rest_name)
    TextView mRestName;
    @BindView(R.id.tv_rest_location)
    TextView mRestLocation;
    @BindView(R.id.tv_rest_open_time_status)
    TextView mRestOpenStatus;
    @BindView(R.id.tv_rest_open_time)
    TextView mRestOpenTime;
    @BindView(R.id.tv_rest_distance)
    TextView mRestDistance;
    @BindView(R.id.tv_rating_number)
    TextView mRatingNumber;
    @BindView(R.id.rest_rating)
    RatingBar mRestRating;
    @BindView(R.id.tv_total_comment)
    TextView mTotalComment;
    @BindView(R.id.btn_reserve)
    Button mReserve;
    @BindView(R.id.user_rating)
    RatingBar mUserRating;
    @BindView(R.id.rv_comment)
    RecyclerView mCommentList;
    @BindView(R.id.tv_write_comment)
    TextView mWriteComment;
    @BindView(R.id.btn_back)
    ImageView mBack;
    @BindView(R.id.tv_appbar_title)
    TextView mAppbarTitle;
    @BindView(R.id.reserve_layout)
    ConstraintLayout mReserveLayout;

    private int[] screenSize;
    private DetailContract.Presenter mPresenter;
    private CommentAdapter mCommentAdapter;

    @Override
    public int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    public void init() {
        mPresenter = new DetailPresent(this, this);
        mCommentAdapter = new CommentAdapter(this);
        screenSize = getScreenSize();
        optimizeGallery();
        mPresenter.getRestDetail();
        mCommentList.addItemDecoration(new CommentDecoration(getDrawable(R.drawable.divider)));
        SnapHelper snapHelper = new CommentSnapHelper();
        snapHelper.attachToRecyclerView(mCommentList);
        mAppbar.addOnOffsetChangedListener(this);
    }



    public void optimizeGallery(){
        GridLayout.LayoutParams galleryParams1 = (GridLayout.LayoutParams) mMainImage.getLayoutParams();
        galleryParams1.width = screenSize[0]/2;
        galleryParams1.height = screenSize[0]/2;
        mMainImage.setLayoutParams(galleryParams1);
        GridLayout.LayoutParams galleryParams2 = (GridLayout.LayoutParams) mGalleryDetail.getLayoutParams();
        galleryParams1.width = screenSize[0]/2;
        galleryParams1.height = screenSize[0]/2;
        mGalleryDetail.setLayoutParams(galleryParams2);

        GridLayout.LayoutParams galleryDetailParams1 = (GridLayout.LayoutParams) mDetailImage1.getLayoutParams();
        galleryDetailParams1.width = screenSize[0]/4;
        galleryDetailParams1.height = screenSize[0]/4;
        mDetailImage1.setLayoutParams(galleryDetailParams1);
        GridLayout.LayoutParams galleryDetailParams2 = (GridLayout.LayoutParams) mDetailImage2.getLayoutParams();
        galleryDetailParams2.width = screenSize[0]/4;
        galleryDetailParams2.height = screenSize[0]/4;
        mDetailImage2.setLayoutParams(galleryDetailParams2);
        GridLayout.LayoutParams galleryDetailParams3 = (GridLayout.LayoutParams) mDetailImage3.getLayoutParams();
        galleryDetailParams3.width = screenSize[0]/4;
        galleryDetailParams3.height = screenSize[0]/4;
        mDetailImage3.setLayoutParams(galleryDetailParams3);
        GridLayout.LayoutParams galleryDetailParams4 = (GridLayout.LayoutParams) mDetailImage4.getLayoutParams();
        galleryDetailParams4.width = screenSize[0]/4;
        galleryDetailParams4.height = screenSize[0]/4;
        mDetailImage4.setLayoutParams(galleryDetailParams4);
    }

    public int[] getScreenSize(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        return new int[]{width, height};
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showComment(List<Comment> comments) {
        mCommentAdapter.addAll(comments);
        mCommentList.setAdapter(mCommentAdapter);
    }

    @Override
    public void showRestDetail() {

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(Math.abs(verticalOffset) >= mAppbar.getTotalScrollRange()){
            mRestRating.setVisibility(View.GONE);
            mRatingNumber.setVisibility(View.GONE);
            mTotalComment.setVisibility(View.GONE);
            mAppbarTitle.setVisibility(View.VISIBLE);
            mBack.setImageDrawable(getDrawable(R.drawable.ic_arrow_orange));
            mReserveLayout.setBackgroundColor(getResources().getColor(R.color.white_transparent));
            mToolbarDetail.setBackgroundColor(getResources().getColor(R.color.white));

        } else {
            mRestRating.setVisibility(View.VISIBLE);
            mRatingNumber.setVisibility(View.VISIBLE);
            mTotalComment.setVisibility(View.VISIBLE);
            mAppbarTitle.setVisibility(View.GONE);
            mBack.setImageDrawable(getDrawable(R.drawable.ic_arrow_back));
            mReserveLayout.setBackgroundColor(getResources().getColor(R.color.white));
            mToolbarDetail.setBackgroundColor(getResources().getColor(R.color.white_transparent));
        }
    }
}
