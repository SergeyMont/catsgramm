package ru.yandex.practicum.catsgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Post> findAll(int from, int size, String sort){
        return posts.stream().sorted((p0, p1) -> {
            int comp = p0.getCreationDate().compareTo(p1.getCreationDate()); //прямой порядок сортировки
            if(sort.equals("desc")){
                comp = -1 * comp; //обратный порядок сортировки
            }
            return comp;
        }).skip(from).limit(size).collect(Collectors.toList());
    }

    public Post findPostById(int postId){
        return posts.stream()
                .filter(x -> x.getId() == postId)
                .findFirst()
                .orElse(null);
    }
}
