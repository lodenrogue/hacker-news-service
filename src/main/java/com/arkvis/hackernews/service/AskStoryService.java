package com.arkvis.hackernews.service;

import com.arkvis.hackernews.config.RetrofitConfig;
import com.arkvis.hackernews.repository.AskStoryRepository;
import com.arkvis.hackernews.repository.StoryRepository;

public class AskStoryService extends AbstractStoryService {

    public AskStoryService() {
        this(RetrofitConfig.createRetrofit().create(AskStoryRepository.class));
    }

    public AskStoryService(StoryRepository storyRepository) {
        super(storyRepository);
    }
}
