package com.arkvis.ycservice.service;

import com.arkvis.ycservice.model.Story;
import com.arkvis.ycservice.repository.StoryRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractStoryService implements StoryService {

    private StoryRepository storyRepository;

    public AbstractStoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
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
            return storyRepository.getStoryById(id).execute().body();
        } catch (IOException ex) {
            return null;
        }
    }

    private List<Long> getStoryIds() {
        try {
            return storyRepository.getStoryIds().execute().body();
        } catch (IOException ex) {
            return Collections.emptyList();
        }
    }
}
