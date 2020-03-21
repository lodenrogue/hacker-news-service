package com.arkvis.ycservice.service;

import com.arkvis.ycservice.model.Story;
import com.arkvis.ycservice.repository.StoryRepository;
import com.arkvis.ycservice.repository.StoryRepositoryImpl;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public abstract class AbstractStoryTest {
    private StoryService storyService;

    protected void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    protected StoryRepository createStoryRepository() {
        StoryRepositoryImpl storyRepository = new StoryRepositoryImpl();
        storyRepository.addStories(Arrays.asList(
                createStory(1L, 0, "Story 1", null, "Story 1 text"),
                createStory(2L, 10, "Story 2", "http://example.com", null),
                createStory(3L, 20, "story 3", null, "Story 3 text")));
        return storyRepository;
    }

    @Test
    public void should_returnStories_when_gettingAllStories() {
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
    }

    @Test
    public void should_returnStoriesWithScoreGreaterThanOrEqualToGivenScore_when_gettingStories() {
        Stream.of(0, 10, 20)
                .map(scoreThreshold -> Pair.of(scoreThreshold, storyService.getStories(scoreThreshold)))
                .forEach(pair -> doThresholdAsserts(pair.getLeft(), pair.getRight()));
    }

    @Test
    public void should_returnStoriesWithTitle_when_gettingAllStories() {
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
        stories.forEach(story -> assertNotNull(story.getTitle()));
    }

    @Test
    public void should_returnStoriesWithTitle_when_gettingStoriesWithThreshold() {
        List<Story> stories = storyService.getStories(0);
        assertFalse(stories.isEmpty());
        stories.forEach(story -> assertNotNull(story.getTitle()));
    }


    @Test
    public void should_returnStoriesWithTextOrUrl_when_gettingAllStories() {
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
        stories.forEach(story -> assertTrue(story.getUrl() != null || story.getText() != null));
    }

    @Test
    public void should_returnStoriesWithTextOrUrl_when_gettingStoriesWithThreshold() {
        List<Story> stories = storyService.getStories(0);
        assertFalse(stories.isEmpty());
        stories.forEach(story -> assertTrue(story.getUrl() != null || story.getText() != null));
    }

    @Test
    public void should_returnStoriesWithId_when_gettingAllStories() {
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
        stories.forEach(story -> assertNotNull(story.getId()));
    }

    private Story createStory(long id, int score, String title, String url, String text) {
        Story story = new Story();
        story.setId(id);
        story.setScore(score);
        story.setTitle(title);
        story.setUrl(url);
        story.setText(text);
        return story;
    }

    private void doThresholdAsserts(Integer scoreThreshold, List<Story> stories) {
        assertFalse(stories.isEmpty());
        stories.forEach(story -> assertTrue(story.getScore() >= scoreThreshold));
    }
}
