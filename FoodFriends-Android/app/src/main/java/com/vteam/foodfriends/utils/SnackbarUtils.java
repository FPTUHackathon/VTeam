package com.vteam.foodfriends.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class SnackbarUtils {
    public static Snackbar getInstance(View view, String message){
        return Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
    }
}
