package com.vteam.foodfriends.ui.partner;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vteam.foodfriends.R;
import com.vteam.foodfriends.ui.custom_view.TimeTextView;
import com.vteam.foodfriends.utils.AppUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by H2PhySicS on 12/2/2017.
 */

public class ReserveDialog extends Dialog implements View.OnClickListener{
    private static final String LOG_TAG = ReserveDialog.class.getSimpleName();
    @BindView(R.id.time_layout)
    LinearLayout mTimeLayout;
    @BindView(R.id.tv_hour)
    TextView mHour;
    @BindView(R.id.tv_minute)
    TextView mMinute;
    @BindView(R.id.tv_day_1)
    TimeTextView mDay1;
    @BindView(R.id.tv_day_2)
    TimeTextView mDay2;
    @BindView(R.id.tv_day_3)
    TimeTextView mDay3;
    @BindView(R.id.tv_day_4)
    TimeTextView mDay4;
    @BindView(R.id.tv_day_5)
    TimeTextView mDay5;
    @BindView(R.id.btn_ok)
    Button mOk;
    @BindView(R.id.imv_single)
    ImageView mSingle;
    @BindView(R.id.imv_group)
    ImageView mGroup;

    private String currentDate;
    private boolean isSingle = true;
    private int index = 0;
    private String [] dates;

    private Context mContext;
    private OnClick listener;
    public ReserveDialog(@NonNull Context context, OnClick listener) {
        super(context);
        mContext = context;
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_ok: {
                String time = new Date().toString();
                listener.onOkClick(time);
                dismiss();
                break;
            }
            case R.id.tv_day_1: {
                setSelectedDay(0);
                break;
            }
            case R.id.tv_day_2: {
                setSelectedDay(1);
                break;
            }
            case R.id.tv_day_3: {
                setSelectedDay(2);
                break;
            }
            case R.id.tv_day_4: {
                setSelectedDay(3);
                break;
            }
            case R.id.tv_day_5: {
                setSelectedDay(4);
                break;
            }
            case R.id.imv_single: {
                isSingle = true;
                break;
            }
            case R.id.imv_group: {
                isSingle = false;
                break;
            }
        }
    }

    public interface OnClick{
        void onOkClick(String time);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_reserve);
        ButterKnife.bind(this);
        mOk.setOnClickListener(this);
        mDay1.setOnClickListener(this);
        mDay2.setOnClickListener(this);
        mDay3.setOnClickListener(this);
        mDay4.setOnClickListener(this);
        mDay5.setOnClickListener(this);
        mSingle.setOnClickListener(this);
        mGroup.setOnClickListener(this);

        initData();

    }

    private void initData(){
        mHour.setFilters(new InputFilter[]{new InputFilterMinMax("0", "23")});
        mMinute.setFilters(new InputFilter[]{new InputFilterMinMax("0", "59")});
        currentDate = AppUtils.getCurrentTime();
        String[] dateSplit = currentDate.split(":");
        mHour.setText(dateSplit[0]);
        mMinute.setText(dateSplit[1]);

        dates = AppUtils.getDates(5);
        mDay1.setText(AppUtils.getDayOfDate(dates[0]));
        mDay2.setText(AppUtils.getDayOfDate(dates[1]));
        mDay3.setText(AppUtils.getDayOfDate(dates[2]));
        mDay4.setText(AppUtils.getDayOfDate(dates[3]));
        mDay5.setText(AppUtils.getDayOfDate(dates[4]));

        setTypeReserve(isSingle);
        setSelectedDay(0);
    }

    private void setSelectedDay(int position){
        index = position;
        switch (position){
            case 1: {
                mDay2.setSelectedItem();
                mDay1.removeSelectedItem();
                mDay3.removeSelectedItem();
                mDay4.removeSelectedItem();
                mDay5.removeSelectedItem();
                break;
            }
            case 2: {
                mDay3.setSelectedItem();
                mDay2.removeSelectedItem();
                mDay1.removeSelectedItem();
                mDay4.removeSelectedItem();
                mDay5.removeSelectedItem();
                break;
            }
            case 3: {
                mDay4.setSelectedItem();
                mDay2.removeSelectedItem();
                mDay3.removeSelectedItem();
                mDay1.removeSelectedItem();
                mDay5.removeSelectedItem();
                break;
            }
            case 4: {
                mDay5.setSelectedItem();
                mDay2.removeSelectedItem();
                mDay3.removeSelectedItem();
                mDay4.removeSelectedItem();
                mDay1.removeSelectedItem();
                break;
            }
            case 0: {

            }
            default: {
                mDay1.setSelectedItem();
                mDay2.removeSelectedItem();
                mDay3.removeSelectedItem();
                mDay4.removeSelectedItem();
                mDay5.removeSelectedItem();
                break;
            }
        }
    }

    private void setTypeReserve(boolean isSingle){
        if (isSingle){

        } else {

        }
    }
}
