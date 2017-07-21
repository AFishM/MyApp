package com.xu.net;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xzx on 2017/7/21.
 */

public class HostSelectionInterceptor implements Interceptor{
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        if(!TextUtils.isEmpty(host)){
            HttpUrl newUrl=request.url().newBuilder().host(host).build();
            request=request.newBuilder().url(newUrl).build();
        }
        return chain.proceed(request);
    }
}
