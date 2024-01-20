package com.weslleycabral.workshopmongodb.services;

import com.weslleycabral.workshopmongodb.entities.Post;
import com.weslleycabral.workshopmongodb.repository.PostRepository;
import com.weslleycabral.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> findPost = repository.findById(id);
        if (findPost.isPresent()) {
            Post post = findPost.get();
            return post;
        } else {
            throw new ObjectNotFoundException("This post not existing");
        }
    }
    public List<Post> findAll() {
        List <Post> posts = repository.findAll();
        return posts;
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }
}
