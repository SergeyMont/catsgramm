package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private  static final Logger log = LoggerFactory.getLogger(PostController.class);
    private List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> findAll() {
        log.debug("Количество постов:"+posts.size());
        return posts;
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

}
