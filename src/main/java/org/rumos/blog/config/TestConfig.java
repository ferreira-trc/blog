package org.rumos.blog.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import org.rumos.blog.model.Person;
import org.rumos.blog.model.Post;
import org.rumos.blog.model.User;
import org.rumos.blog.repositories.PersonRepository;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person(null, "Tiago Ferreira", LocalDate.now());
        Person person2 = new Person(null, "Rute Andrade", LocalDate.now());

        personRepository.saveAll(Arrays.asList(person1,person2));

        User user1 = new User(null, "@ferreira_trc", "1234", "admin", person1);
        User user2 = new User(null, "@andrade_rm", "1234", "admin", person2);

        userRepository.saveAll(Arrays.asList(user1,user2));

        String path1 = "Mar Portugues.txt";
        String path2 = "O Infante.txt";

        Post post1 = postBuilder(path1);
        Post post2 = postBuilder(path2);

        postRepository.saveAll(Arrays.asList(post1,post2));

        
    }

    public Post postBuilder (String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        StringBuilder text = new StringBuilder();
        String title = "";
        String linha = "";

        title = buffRead.readLine();

        while (true) {
            if (linha != null) {
               text.append(linha + "\n");

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();

        Post post = new Post(null, title, text.toString(), LocalDate.now(), "Poesia");

        return post;
    }

}
