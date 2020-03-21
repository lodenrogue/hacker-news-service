package com.arkvis.hackernews.service;

import com.arkvis.hackernews.model.Story;

import java.util.List;

public interface StoryService {

    List<Story> getAllStories();

    List<Story> getStories(int scoreThreshold);
}
