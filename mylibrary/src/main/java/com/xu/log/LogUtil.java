package com.xu.log;

import android.util.Log;

import com.xu.Config;

/**
 * 可以定位代码位置的日志
 * Created by xzx on 2017/7/21.
 */

public class LogUtil {
    public static final String TAG = "";

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void wtf(String msg) {
        wtf(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (Config.debug) {
            Log.v(tag, getCodeLocation() + msg);
        }
    }

    public static void d(String tag, String msg) {
        if (Config.debug) {
            Log.d(tag, getCodeLocation() + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (Config.debug) {
            Log.i(tag, getCodeLocation() + msg);
        }
    }

    public static void w(String tag, String msg) {
        if (Config.debug) {
            Log.w(tag, getCodeLocation() + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (Config.debug) {
            Log.e(tag, getCodeLocation() + msg);
        }
    }

    public static void wtf(String tag, String msg) {
        if (Config.debug) {
            Log.wtf(tag, getCodeLocation() + msg);
        }
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
