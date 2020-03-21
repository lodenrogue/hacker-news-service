package com.arkvis.hackernews.repository;

import com.arkvis.hackernews.model.Story;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface StoryRepository {

    Call<List<Long>> getStoryIds();

    @GET("https://hacker-news.firebaseio.com/v0/item/{id}.json")
    Call<Story> getStoryById(@Path("id") Long id);
}
