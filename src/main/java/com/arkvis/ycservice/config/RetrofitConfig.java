package com.arkvis.ycservice.config;

import com.arkvis.ycservice.service.YCService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private RetrofitConfig() {}

    private static Retrofit retrofit;

    public static Retrofit createRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(YCService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
