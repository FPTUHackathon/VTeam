package com.vteam.foodfriends.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class AppUtils {
    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(date);
    }

    public static String[] getDates(int numDay){
        Date date = new Date();

        String[] day = new String[7];
        long currentTime = date.getTime();
        for (int i = 0; i < numDay; i++){
            date.setTime(currentTime);
            String[] str = date.toString().split(" ");
            day[i] = str[0] + " - " + str[1] + " - " + str[2];
            currentTime += TimeUnit.DAYS.toMillis(1);
        }

        return day;
    }

    public static String getDayOfDate(String date){
        String[] dateSplit = date.split(" - ");
        return dateSplit[2];
    }

    public static int getDistance(double latUser, double lonUser, double latShop, double lonShop){
        int distance = (int) Math.sqrt(Math.pow(latUser - latShop, 2) + Math.pow(lonUser - lonShop, 2));
        return distance;
    }

    public static boolean isOpening(String openTime, String closeTime){
        boolean isOpen = false;


        return isOpen;
    }
}
