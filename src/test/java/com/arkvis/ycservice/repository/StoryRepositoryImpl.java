package com.arkvis.ycservice.repository;

import com.arkvis.ycservice.model.Story;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoryRepositoryImpl implements StoryRepository {

    private Map<Long, Story> stories;

    public StoryRepositoryImpl() {
        stories = new HashMap<>();
    }

    public void addStories(List<Story> newStories) {
        newStories.forEach(story -> stories.put(story.getId(), story));
    }

    @Override
    public Call<List<Long>> getStoryIds() {
        return new AbstractCallAdapter<List<Long>>() {
            @Override
            public Response<List<Long>> execute() {
                return Response.success(new ArrayList<>(stories.keySet()));
            }
        };
    }

    @Override
    public Call<Story> getStoryById(Long id) {
        return new AbstractCallAdapter<Story>() {
            @Override
            public Response<Story> execute() {
                return Response.success(stories.get(id));
            }
        };
    }
}
