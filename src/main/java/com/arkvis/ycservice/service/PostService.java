package com.arkvis.ycservice.service;

import com.arkvis.ycservice.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    List<Post> getPosts(int scoreThreshold);
}
