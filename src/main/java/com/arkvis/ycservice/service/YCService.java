package com.arkvis.ycservice.service;

import com.arkvis.ycservice.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface YCService {

    String BASE_URL = "https://hacker-news.firebaseio.com/v0/";

    @GET("showstories.json")
    Call<List<Integer>> getStoryIds();

    @GET("https://hacker-news.firebaseio.com/v0/item/{id}.json")
    Call<Post> getPostById(@Path("id") Integer id);
}
