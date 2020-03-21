package com.arkvis.ycservice.service;

import com.arkvis.ycservice.config.RetrofitConfig;
import com.arkvis.ycservice.repository.ShowStoryRepository;
import com.arkvis.ycservice.repository.StoryRepository;

public class ShowStoryService extends AbstractStoryService {

    public ShowStoryService() {
        this(RetrofitConfig.createRetrofit().create(ShowStoryRepository.class));
    }

    ShowStoryService(StoryRepository showStoryRepository) {
        super(showStoryRepository);
    }
}
