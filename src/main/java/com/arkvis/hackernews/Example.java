package com.arkvis.hackernews;

import com.arkvis.hackernews.model.Story;
import com.arkvis.hackernews.service.TopStoryService;
import com.google.gson.GsonBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        sortedExample();
        getAllExample();
    }

    private static void getAllExample() {
        List<Story> stories = new TopStoryService().getAllStories();
        System.out.println(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(stories));
    }

    private static void sortedExample() {
        int scoreThreshold = 100;
        List<Story> stories = new TopStoryService().getStories(scoreThreshold);

        List<Story> sortedStories = stories.stream()
                .filter(post -> post.getUrl() != null)
                .sorted(Comparator.comparingInt(Story::getScore).reversed())
                .collect(Collectors.toList());

        System.out.println(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(sortedStories));
    }
}
