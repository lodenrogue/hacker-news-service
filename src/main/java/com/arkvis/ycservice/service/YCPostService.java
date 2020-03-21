package com.arkvis.ycservice.service;

import com.arkvis.ycservice.config.RetrofitConfig;
import com.arkvis.ycservice.model.Post;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class YCPostService implements PostService {

    private YCService ycService;

    public YCPostService() {
        this(RetrofitConfig.createRetrofit().create(YCService.class));
    }

    YCPostService(YCService ycService) {
        this.ycService = ycService;
    }

    @Override
    public List<Post> getAllPosts() {
        return getPosts(0);
    }

    @Override
    public List<Post> getPosts(int scoreThreshold) {
        return getPostIds().parallelStream()
                .map(this::getPost)
                .filter(Objects::nonNull)
                .filter(post -> post.getScore() > scoreThreshold)
                .collect(Collectors.toList());
    }

    private Post getPost(Integer id) {
        try {
            return ycService.getPostById(id).execute().body();
        } catch (IOException ex) {
            return null;
        }
    }

    private List<Integer> getPostIds() {
        try {
            return ycService.getStoryIds().execute().body();
        } catch (IOException ex) {
            return Collections.emptyList();
        }
    }
}
