package com.vteam.foodfriends.ui.test;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.base.BaseActivity;
import com.vteam.foodfriends.ui.custom_view.TimeTextView;
import com.vteam.foodfriends.ui.partner.InputFilterMinMax;
import com.vteam.foodfriends.ui.partner.ReserveDialog;
import com.vteam.foodfriends.utils.AppUtils;

import butterknife.BindView;

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class TestActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_day_1)
    TimeTextView mDay1;
    @BindView(R.id.tv_hour)
    TextView mHour;
    @BindView(R.id.tv_minute)
    TextView mMinute;
    @BindView(R.id.btn_ok)
    Button mOk;

    @Override
    public int getContentView() {
        return R.layout.dialog_reserve;
    }

    @Override
    public void init() {
//        mHour.setFilters(new InputFilter[]{new InputFilterMinMax("0", "23")});
//        mMinute.setFilters(new InputFilter[]{new InputFilterMinMax("0", "59")});
//        Log.e("TestActivity", AppUtils.getCurrentTime());
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReserveDialog mDialog = new ReserveDialog(TestActivity.this, new ReserveDialog.OnClick() {
                    @Override
                    public void onOkClick() {

                    }
                });
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();
            }
        });

//        mDay1.setSelectedItem();
//        mDay1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        mDay1.removeSelectedItem();
    }
}
