package com.vteam.foodfriends.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vteam.foodfriends.utils.Constant;

/**
 * Created by H2PhySicS on 11/30/2017.
 */

public class AppPreferences {
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    public AppPreferences(Context context){
        this.mContext = context;
        mPref = mContext.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime){
        mEditor.putBoolean(Constant.PREF_FIRST_LAUNCH, isFirstTime);
        mEditor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return mPref.getBoolean(Constant.PREF_FIRST_LAUNCH, true);
    }
}
