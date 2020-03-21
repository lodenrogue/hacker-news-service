package com.arkvis.ycservice;

import com.arkvis.ycservice.model.Post;
import com.arkvis.ycservice.service.YCPostService;
import com.google.gson.GsonBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Post> posts = new YCPostService().getPosts(0);
        List<Post> sortedPosts = posts.stream()
                .filter(post -> post.getUrl() != null)
                .sorted(Comparator.comparingInt(Post::getScore).reversed())
                .collect(Collectors.toList());

        System.out.println(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(sortedPosts));
    }
}
