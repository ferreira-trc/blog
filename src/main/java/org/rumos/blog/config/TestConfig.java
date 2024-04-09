package org.rumos.blog.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.rumos.blog.model.Person;
import org.rumos.blog.model.User;
import org.rumos.blog.repositories.PersonRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person(null, "Tiago Ferreira", LocalDate.now());
        Person person2 = new Person(null, "Rute Andrade", LocalDate.now());

        personRepository.saveAll(Arrays.asList(person1,person2));

        User user1 = new User(null, "@ferreira_trc", "1234", "admin", person1);
        User user2 = new User(null, "@andrade_rm", "1234", "admin", person2);

        userRepository.saveAll(Arrays.asList(user1,user2));
    }


}
