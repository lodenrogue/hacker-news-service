package com.arkvis.hackernews.service;

import com.arkvis.hackernews.config.RetrofitConfig;
import com.arkvis.hackernews.repository.JobStoryRepository;
import com.arkvis.hackernews.repository.StoryRepository;

public class JobStoryService extends AbstractStoryService {

    public JobStoryService() {
        this(RetrofitConfig.createRetrofit().create(JobStoryRepository.class));
    }

    public JobStoryService(StoryRepository storyRepository) {
        super(storyRepository);
    }
}
