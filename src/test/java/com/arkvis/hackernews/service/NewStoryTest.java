package com.arkvis.hackernews.service;

import com.arkvis.hackernews.model.Story;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class NewStoryTest extends AbstractStoryTest {

    @Before
    public void setUp() {
        setStoryService(new NewStoryService(createStoryRepository()));
    }

    @Test
    public void should_returnNewStories_when_callingRealService() {
        StoryService storyService = new NewStoryService();
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
    }
}
