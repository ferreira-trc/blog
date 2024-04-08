package org.rumos.blog.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.rumos.blog.model.Person;
import org.rumos.blog.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person(null, "Tiago Ferreira", LocalDate.now());
        Person person2 = new Person(null, "Rute Andrade", LocalDate.now());

        personRepository.saveAll(Arrays.asList(person1,person2));
    }


}
