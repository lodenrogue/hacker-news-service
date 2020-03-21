package com.arkvis.ycservice.service;

import com.arkvis.ycservice.model.Story;

import java.util.List;

public interface StoryService {

    List<Story> getAllStories();

    List<Story> getStories(int scoreThreshold);
}
