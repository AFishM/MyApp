package com.xu.myapp;

import android.app.Application;

import com.xu.Config;

/**
 * Created by xzx on 2017/8/18.
 */

public class AppContext extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Config.init(this);
    }
}
