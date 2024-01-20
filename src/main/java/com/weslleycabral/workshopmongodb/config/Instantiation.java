package com.weslleycabral.workshopmongodb.config;

import com.weslleycabral.workshopmongodb.dto.AuthorDTO;
import com.weslleycabral.workshopmongodb.dto.CommentDTO;
import com.weslleycabral.workshopmongodb.entities.User;
import com.weslleycabral.workshopmongodb.entities.Post;
import com.weslleycabral.workshopmongodb.repository.PostRepository;
import com.weslleycabral.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post post1 = new Post(null, format.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post post2 = new Post(null, format.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u2));

        CommentDTO co1 = new CommentDTO("Boa viagem Fulano De Tal", format.parse("21/12/2022"), new AuthorDTO(u1));
        CommentDTO co2 = new CommentDTO("Tomara que dê errado!", format.parse("07/08/2024"), new AuthorDTO(u3));

        post1.getCommentDTO().add(co2);
        post1.getCommentDTO().add(co1);

        postRepository.saveAll(Arrays.asList(post1, post2));

        u1.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(u1);

    }
}
