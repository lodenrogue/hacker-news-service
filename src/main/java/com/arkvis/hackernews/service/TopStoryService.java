package com.arkvis.hackernews.service;

import com.arkvis.hackernews.config.RetrofitConfig;
import com.arkvis.hackernews.repository.StoryRepository;
import com.arkvis.hackernews.repository.TopStoryRepository;

public class TopStoryService extends AbstractStoryService {

    public TopStoryService() {
        this(RetrofitConfig.createRetrofit().create(TopStoryRepository.class));
    }

    TopStoryService(StoryRepository topStoryRepository) {
        super(topStoryRepository);
    }

}
