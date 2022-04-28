package ru.yandex.practicum.catsgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private  final List<Post> posts=new ArrayList<>();
    private final UserService userService;

    @Autowired
    public PostService(UserService userService){
        this.userService=userService;
    }

    public Post create(Post post){
        if(userService.findUserByEmail(post.getAuthor())==null){
            throw new UserNotFoundException("Пользователь "+post.getAuthor() +" не найден");
        }
        posts.add(post);
        return post;
    }

    public List<Post> findAll(){
        return posts;
    }
}