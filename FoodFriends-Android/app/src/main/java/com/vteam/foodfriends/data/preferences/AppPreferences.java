package com.vteam.foodfriends.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.vteam.foodfriends.data.model.User;
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

    public void setUser(User user){
        mEditor.putString(Constant.PREF_USER_ID, user.getId());
        mEditor.putString(Constant.PREF_USER_EMAIL, user.getEmail());
        mEditor.putString(Constant.PREF_USER_NAME, user.getName());
        mEditor.putString(Constant.PREF_USER_PHONE, user.getPhone());
        mEditor.putString(Constant.PREF_USER_DOB, user.getDob());
//        mEditor.putString(Constant.PREF_USER_AVATAR, user.getAvatar());
        mEditor.putBoolean(Constant.PREF_USER_GENDER, user.isMale());
        mEditor.commit();
    }

    public User getCurrentUser(){
        String uid = mPref.getString(Constant.PREF_USER_ID, null);
        String email = mPref.getString(Constant.PREF_USER_EMAIL, null);
        String name = mPref.getString(Constant.PREF_USER_NAME, null);
        String phone = mPref.getString(Constant.PREF_USER_PHONE, null);
        String dob = mPref.getString(Constant.PREF_USER_DOB, null);
//        String avatar = mPref.getString(Constant.PREF_USER_AVATAR, null);
        boolean isMale = mPref.getBoolean(Constant.PREF_USER_GENDER, true);
        return new User(uid, email, name, phone, dob, isMale);
    }
}
