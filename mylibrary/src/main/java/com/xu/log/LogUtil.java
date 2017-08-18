package com.xu.log;

import android.util.Log;

import com.xu.Config;

/**
 * 可以定位代码位置的日志
 * Created by xzx on 2017/7/21.
 */

public class LogUtil {
    private static final String TAG = "xzx";

    public static void v(String msg) {
        if (isDebug()) {
            Log.v(TAG, getCodeLocation() + msg);
        }
    }

    public static void d(String msg) {
        if (isDebug()) {
            Log.d(TAG, getCodeLocation() + msg);
        }
    }

    public static void i(String msg) {
        if (isDebug()) {
            Log.i(TAG, getCodeLocation() + msg);
        }
    }

    public static void w(String msg) {
        if (isDebug()) {
            Log.w(TAG, getCodeLocation() + msg);
        }
    }

    public static void e(String msg) {
        if (isDebug()) {
            Log.e(TAG, getCodeLocation() + msg);
        }
    }

    public static void wtf(String msg) {
        if (isDebug()) {
            Log.wtf(TAG, getCodeLocation() + msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug()) {
            Log.v(tag, getCodeLocation() + msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug()) {
            Log.d(tag, getCodeLocation() + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug()) {
            Log.i(tag, getCodeLocation() + msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug()) {
            Log.w(tag, getCodeLocation() + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug()) {
            Log.e(tag, getCodeLocation() + msg);
        }
    }

    public static void wtf(String tag, String msg) {
        if (isDebug()) {
            Log.wtf(tag, getCodeLocation() + msg);
        }
    }

    private static boolean isDebug(){
        return Config.getInstance().isDebug();
    }

    private static String getCodeLocation() {
        String codeLocation = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements != null && stackTraceElements.length > 4) {
            StackTraceElement stackTraceElement = stackTraceElements[4];
            codeLocation = String.format("%s.%s()(line:%s):", stackTraceElement.getFileName(), stackTraceElement.getMethodName(), stackTraceElement.getLineNumber());
        }
        return codeLocation;
    }
}
