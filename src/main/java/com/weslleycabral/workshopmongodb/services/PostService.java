package com.weslleycabral.workshopmongodb.services;

import com.weslleycabral.workshopmongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


}
