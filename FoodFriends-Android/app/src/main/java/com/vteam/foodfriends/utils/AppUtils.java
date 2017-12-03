package com.vteam.foodfriends.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by H2PhySicS on 11/29/2017.
 */

public class AppUtils {
    private static final String LOG_TAG = AppUtils.class.getSimpleName();
    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(date);
    }

    public static String[] getDates(int numDay){
        Date date = new Date();

        String[] day = new String[numDay];
        long currentTime = date.getTime();
        for (int i = 0; i < numDay; i++){
            date.setTime(currentTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm/dd/MM/yyyy");
            day[i] = simpleDateFormat.format(date);
            Log.e(LOG_TAG, "Day: " + day[i]);
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

    public static int getAge(String birdthday){
        int age = 0;
        return age;
    }

    public static Date convertStringToDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm/dd/MM/yyyy");
        Date date1 = simpleDateFormat.parse(date);
        return date1;
    }

    public static String convertDateToString(Date date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm/dd/MM/yyyy");

        return simpleDateFormat.format(date);
    }

    public static String getDayOfDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        return simpleDateFormat.format(date);
    }
}
