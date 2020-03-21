package com.arkvis.ycserivce;

import com.arkvis.ycservice.model.Post;
import com.arkvis.ycservice.service.PostService;
import com.arkvis.ycservice.service.YCPostService;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PostTest {

    private PostService postService;

    @Before
    public void setUp() {
        postService = new YCPostService();
    }

    @Test
    public void should_returnPosts_when_gettingPosts() {
        List<Post> posts = postService.getAllPosts();
        assertFalse(posts.isEmpty());
    }

    @Test
    public void should_returnPostsWithScoreGreaterThanOrEqualToGivenScore_when_gettingPosts() {
        Stream.of(0, 10, 20)
                .map(scoreThreshold -> Pair.of(scoreThreshold, postService.getPosts(scoreThreshold)))
                .forEach(pair -> doThresholdAsserts(pair.getLeft(), pair.getRight()));
    }

    @Test
    public void should_returnPostsWithTitle_when_gettingAllPosts() {
        List<Post> posts = postService.getAllPosts();
        assertFalse(posts.isEmpty());
        posts.forEach(post -> assertNotNull(post.getTitle()));
    }

    @Test
    public void should_returnPostsWithTitle_when_gettingPostsWithThreshold() {
        List<Post> posts = postService.getPosts(0);
        assertFalse(posts.isEmpty());
        posts.forEach(post -> assertNotNull(post.getTitle()));
    }


    @Test
    public void should_returnPostsWithTextOrUrl_when_gettingAllPosts() {
        List<Post> posts = postService.getAllPosts();
        assertFalse(posts.isEmpty());
        posts.forEach(post -> assertTrue(post.getUrl() != null || post.getText() != null));
    }

    @Test
    public void should_returnPostsWithTextOrUrl_when_gettingPostsWithThreshold() {
        List<Post> posts = postService.getPosts(0);
        assertFalse(posts.isEmpty());
        posts.forEach(post -> assertTrue(post.getUrl() != null || post.getText() != null));
    }

    @Test
    public void should_returnPostsWithId_when_gettingAllPosts() {
        List<Post> posts = postService.getAllPosts();
        assertFalse(posts.isEmpty());
        posts.forEach(post -> assertNotNull(post.getId()));
    }

    private void doThresholdAsserts(Integer scoreThreshold, List<Post> posts) {
        assertFalse(posts.isEmpty());
        posts.forEach(post -> assertTrue(post.getScore() >= scoreThreshold));
    }
}
