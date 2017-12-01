package com.vteam.foodfriends.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vteam.foodfriends.ui.introduction.IntroActivity;
import com.vteam.foodfriends.ui.login.LoginActivity;

/**
 * Created by H2PhySicS on 11/30/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, IntroActivity.class));
        finish();
    }
}
