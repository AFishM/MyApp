package com.xu.log;

import android.util.Log;

import com.xu.Config;

/**
 * 可以定位代码位置的日志
 * Created by xzx on 2017/7/21.
 */

public class LogUtil {
    public static final String TAG = "xzx";

    public static void v(String msg) {
        if (Config.debug) {
            Log.v(TAG, getCodeLocation() + msg);
        }
    }

    public static void d(String msg) {
        if (Config.debug) {
            Log.d(TAG, getCodeLocation() + msg);
        }
    }

    public static void i(String msg) {
        if (Config.debug) {
            Log.i(TAG, getCodeLocation() + msg);
        }
    }

    public static void w(String msg) {
        if (Config.debug) {
            Log.w(TAG, getCodeLocation() + msg);
        }
    }

    public static void e(String msg) {
        if (Config.debug) {
            Log.e(TAG, getCodeLocation() + msg);
        }
    }

    public static void wtf(String msg) {
        if (Config.debug) {
            Log.wtf(TAG, getCodeLocation() + msg);
        }
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
