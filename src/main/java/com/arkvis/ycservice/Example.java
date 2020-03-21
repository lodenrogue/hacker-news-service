package com.arkvis.ycservice;

import com.arkvis.ycservice.model.Story;
import com.arkvis.ycservice.service.TopStoryService;
import com.google.gson.GsonBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Story> stories = new TopStoryService().getStories(100);
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