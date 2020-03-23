package com.arkvis.hackernews.service;

import com.arkvis.hackernews.config.RetrofitConfig;
import com.arkvis.hackernews.repository.NewStoryRepository;
import com.arkvis.hackernews.repository.StoryRepository;

public class NewStoryService extends AbstractStoryService {

    public NewStoryService() {
        this(RetrofitConfig.createRetrofit().create(NewStoryRepository.class));
    }

    public NewStoryService(StoryRepository storyRepository) {
        super(storyRepository);
    }
}
