package com.weslleycabral.workshopmongodb.config;

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

        Post post1 = new Post(null, format.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", u1);
        Post post2 = new Post(null, format.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", u1);

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
