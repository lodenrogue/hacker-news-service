package com.arkvis.ycservice.service;

import com.arkvis.ycservice.config.RetrofitConfig;
import com.arkvis.ycservice.repository.StoryRepository;
import com.arkvis.ycservice.repository.TopStoryRepository;

public class TopStoryService extends AbstractStoryService {

    public TopStoryService() {
        this(RetrofitConfig.createRetrofit().create(TopStoryRepository.class));
    }

    TopStoryService(StoryRepository topStoryRepository) {
        super(topStoryRepository);
    }

}
