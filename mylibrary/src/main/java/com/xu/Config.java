package com.xu;

import android.content.Context;

/**
 * 配置类
 * Created by xzx on 2017/7/21.
 */

public class Config {
    public static final String SETTING_PREFERENCES_NAME ="settingPreferencesFile";
    public static final String PREFERENCES_KEY_DEBUG="debug";
    private static Config INSTANCE;

    private boolean debug=true;

    public static void init(Context context) {
        INSTANCE=new Config();
        INSTANCE.debug=context.getSharedPreferences(SETTING_PREFERENCES_NAME,Context.MODE_PRIVATE).getBoolean(PREFERENCES_KEY_DEBUG,false);
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
