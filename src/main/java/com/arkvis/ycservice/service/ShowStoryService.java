package com.arkvis.ycservice.service;

import com.arkvis.ycservice.config.RetrofitConfig;
import com.arkvis.ycservice.model.Story;
import com.arkvis.ycservice.model.StoryType;
import com.arkvis.ycservice.repository.ShowStoryRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShowStoryService implements StoryService {

    private ShowStoryRepository showStoryRepository;

    public ShowStoryService() {
        this(RetrofitConfig.createRetrofit().create(ShowStoryRepository.class));
    }

    ShowStoryService(ShowStoryRepository showStoryRepository) {
        this.showStoryRepository = showStoryRepository;
    }

    @Override
    public List<Story> getAllStories() {
        return getStories(0);
    }

    @Override
    public List<Story> getStories(int scoreThreshold) {
        return getStoryIds().parallelStream()
                .map(this::getStory)
                .filter(Objects::nonNull)
                .filter(story -> story.getScore() >= scoreThreshold)
                .collect(Collectors.toList());
    }

    private Story getStory(Long id) {
        try {
            return showStoryRepository.getStoryById(id).execute().body();
        } catch (IOException ex) {
            return null;
        }
    }

    private List<Long> getStoryIds() {
        try {
            return showStoryRepository.getStoryIds().execute().body();
        } catch (IOException ex) {
            return Collections.emptyList();
        }
    }
}
