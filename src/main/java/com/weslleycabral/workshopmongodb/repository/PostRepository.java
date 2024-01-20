package com.weslleycabral.workshopmongodb.repository;

import com.weslleycabral.workshopmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
