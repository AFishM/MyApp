package com.xu.net;

import com.xu.mylibrary.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yaochufa on 2017/7/21.
 */

public class NetService {
    private Retrofit retrofit;

    private static class SingletonHolder {
        private static NetService INSTANCE = new NetService();
    }

    public static NetService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private NetService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (!BuildConfig.BUILD_TYPE.equals("release")) {
            builder.addInterceptor(new HostSelectionInterceptor());
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        OkHttpClient okHttpClient = builder.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Hosts.host)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
