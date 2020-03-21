package com.arkvis.hackernews.service;

import com.arkvis.hackernews.config.RetrofitConfig;
import com.arkvis.hackernews.repository.ShowStoryRepository;
import com.arkvis.hackernews.repository.StoryRepository;

public class ShowStoryService extends AbstractStoryService {

    public ShowStoryService() {
        this(RetrofitConfig.createRetrofit().create(ShowStoryRepository.class));
    }

    ShowStoryService(StoryRepository showStoryRepository) {
        super(showStoryRepository);
    }
}
