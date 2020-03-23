package com.arkvis.hackernews.repository;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface JobStoryRepository extends StoryRepository {

    @GET("jobstories.json")
    Call<List<Long>> getStoryIds();
}
