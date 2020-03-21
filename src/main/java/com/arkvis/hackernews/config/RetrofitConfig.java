package com.arkvis.hackernews.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static final String BASE_URL = "https://hacker-news.firebaseio.com/v0/";

    private RetrofitConfig() {
    }

    private static Retrofit retrofit;

    public static Retrofit createRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
