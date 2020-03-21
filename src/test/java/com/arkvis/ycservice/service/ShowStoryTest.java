package com.arkvis.ycservice.service;

import com.arkvis.ycservice.model.Story;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class ShowStoryTest extends AbstractStoryTest {

    @Before
    public void setUp() {
        setStoryService(new ShowStoryService(createStoryRepository()));
    }

    @Test
    public void should_returnShowStories_when_callingRealService() {
        StoryService storyService = new ShowStoryService();
        List<Story> stories = storyService.getAllStories();
        assertFalse(stories.isEmpty());
    }
}
