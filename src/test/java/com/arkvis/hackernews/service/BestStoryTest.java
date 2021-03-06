package com.arkvis.hackernews.service;

import com.arkvis.hackernews.model.Story;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class BestStoryTest extends AbstractStoryTest {

    @Before
    public void setUp() {
        setStoryService(new BestStoryService(createStoryRepository()));
    }

    @Test
    public void should_returnBestStories_when_callingRealService() {
        StoryService storyService = new BestStoryService();
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
    }
}
