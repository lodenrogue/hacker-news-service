package com.arkvis.hackernews.service;

import com.arkvis.hackernews.config.RetrofitConfig;
import com.arkvis.hackernews.repository.BestStoryRepository;
import com.arkvis.hackernews.repository.StoryRepository;

public class BestStoryService extends AbstractStoryService {

    public BestStoryService() {
        this(RetrofitConfig.createRetrofit().create(BestStoryRepository.class));
    }

    public BestStoryService(StoryRepository storyRepository) {
        super(storyRepository);
    }
}
