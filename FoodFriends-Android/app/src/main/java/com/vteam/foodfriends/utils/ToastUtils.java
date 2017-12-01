package com.vteam.foodfriends.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class ToastUtils {
    public static Toast getInstace(Context context, String message){
        return Toast.makeText(context, message, Toast.LENGTH_SHORT);
    }
}
