package com.vteam.foodfriends.ui.detail_restaurant;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.Comment;
import com.vteam.foodfriends.data.model.Restaurant;
import com.vteam.foodfriends.ui.adapter.CommentAdapter;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.partner.PartnerActivity;
import com.vteam.foodfriends.ui.write_comment.WriteCommentActivity;
import com.vteam.foodfriends.utils.AppUtils;
import com.vteam.foodfriends.utils.Constant;

import java.util.List;

import butterknife.BindView;

public class DetailActivity extends BaseActivity implements DetailContract.View,
        AppBarLayout.OnOffsetChangedListener,
        RatingBar.OnRatingBarChangeListener,
        View.OnClickListener{
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
    @BindView(R.id.btn_reserve1)
    Button mReserve1;
    @BindView(R.id.btn_reserve2)
    Button mReserve2;
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
    @BindView(R.id.header_layout)
    RelativeLayout mHeaderLayout;

    private int[] screenSize;
    private DetailContract.Presenter mPresenter;
    private CommentAdapter mCommentAdapter;
    private boolean isChoose = false;
    private boolean isMovingHalf = false;
    private Restaurant mRestaurant;

    @Override
    public int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    public void init() {
        mPresenter = new DetailPresenter(this, this);
        mCommentAdapter = new CommentAdapter(this);
        screenSize = getScreenSize();
        optimizeGallery();
        mPresenter.getRestDetail(getIntent());
        mCommentList.addItemDecoration(new CommentDecoration(getDrawable(R.drawable.divider)));
        SnapHelper snapHelper = new CommentSnapHelper();
        snapHelper.attachToRecyclerView(mCommentList);
        mAppbar.addOnOffsetChangedListener(this);
        mCommentList.clearFocus();

        mUserRating.setOnRatingBarChangeListener(this);
        mWriteComment.setOnClickListener(this);
        mReserve1.setOnClickListener(this);
        mReserve2.setOnClickListener(this);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showComment(List<Comment> comments) {
        if (comments.size() > 0){
            mCommentAdapter.clear();
            mCommentAdapter.addAll(comments);
            mCommentList.setAdapter(mCommentAdapter);
        } else {
            mCommentList.setVisibility(View.GONE);
        }
    }

    @Override
    public void showRestDetail(Restaurant restaurant) {

        mRestaurant = restaurant;

        Glide.with(this).load(restaurant.getPhotoUrl())
                .asBitmap()
                .into(mHeader);
        mRestName.setText(restaurant.getName());
        mRestOpenTime.setText(restaurant.getTimeOpen() + " - " + restaurant.getTimeClose());
        if (AppUtils.isOpening(restaurant.getTimeOpen(), restaurant.getTimeClose())){
            mRestOpenStatus.setText(getString(R.string.rest_open));
        } else {
            mRestOpenStatus.setText(getString(R.string.rest_close));
        }
//        mRestDistance.setText();
        mAppbarTitle.setText(restaurant.getName());
        mRatingNumber.setText(restaurant.getRating() + "");
        mRestRating.setRating(restaurant.getRating());
        mTotalComment.setText(restaurant.getTotalReview() + " đánh giá");

    }

    @Override
    public void openWriteComment(Restaurant restaurant) {
        Intent intent = new Intent(this, WriteCommentActivity.class);
        intent.putExtra(Constant.EXTRA_RESTAURANT, restaurant);
        startActivityWithAnimation(intent);

    }

    @Override
    public void startPartnerActivity() {
        Intent intent = new Intent(this, PartnerActivity.class);
        intent.putExtra(Constant.EXTRA_RESTAURANT_ID, mRestaurant.getId());
        startActivityWithAnimation(intent);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int offsetPositive = Math.abs(verticalOffset);
        float alphaToolbar = (float) offsetPositive / mAppbar.getTotalScrollRange();
        float alphaHeader = 1 - alphaToolbar;
        setAlpha(mHeaderLayout, alphaHeader);
        if (offsetPositive >= mAppbar.getTotalScrollRange() && isChoose){
            isChoose = false;
            endCollapsed(true);
        } else if(offsetPositive < mAppbar.getTotalScrollRange() && !isChoose){
            isChoose = true;
            endCollapsed(false);
        }

        if (offsetPositive >= mAppbar.getTotalScrollRange() / 2 && isMovingHalf){
            isMovingHalf = false;
            mBack.setImageDrawable(getDrawable(R.drawable.ic_arrow_orange));
        } else if(offsetPositive < mAppbar.getTotalScrollRange() / 2 && !isMovingHalf){
            isMovingHalf = true;
            mBack.setImageDrawable(getDrawable(R.drawable.ic_arrow_back));
        }

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

    private void setAlpha(View view, float alpha){
        view.setAlpha(alpha);
    }

    private void endCollapsed(boolean isEnd){
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        if (isEnd){
            mReserveLayout.clearAnimation();
            mReserveLayout.startAnimation(fadeOut);
            mReserveLayout.setAlpha(0);
            mAppbarTitle.clearAnimation();
            mAppbarTitle.startAnimation(fadeIn);
            mAppbarTitle.setAlpha(1);
            mReserve2.clearAnimation();
            mReserve2.startAnimation(fadeIn);
            mReserve2.setAlpha(1);

        } else {
            mReserveLayout.clearAnimation();
            mReserveLayout.startAnimation(fadeIn);
            mReserveLayout.setAlpha(1);
            mReserve2.clearAnimation();
            mReserve2.startAnimation(fadeOut);
            mReserve2.setAlpha(0);
            mAppbarTitle.clearAnimation();
            mAppbarTitle.startAnimation(fadeOut);
            mAppbarTitle.setAlpha(0);
            mBack.setImageDrawable(getDrawable(R.drawable.ic_arrow_back));
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        Log.e(LOG_TAG, "OnRatingBarChange");
        ratingBar.setRating(v);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_reserve1: {

            }
            case R.id.btn_reserve2: {
                startPartnerActivity();
                break;
            }
            case R.id.tv_write_comment: {
                mPresenter.getResBeforeComment();
                break;
            }
        }

    }
}
