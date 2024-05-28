package org.rumos.blog.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.rumos.blog.model.Comment;
import org.rumos.blog.model.Person;
import org.rumos.blog.model.Post;
import org.rumos.blog.model.User;
import org.rumos.blog.model.enums.Role;
import org.rumos.blog.repositories.CommentRepository;
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

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person(1L, "Tiago Ferreira", LocalDate.now());
        Person person2 = new Person(2L, "Rute Andrade", LocalDate.now());

        personRepository.saveAll(Arrays.asList(person1,person2));

        User user1 = new User(1L, "tiago@ex.com","@ferreira_trc", "1234", Role.ADMIN, person1);
        User user2 = new User(2L,"rute@ex.com","@andrade_rm", "1234", Role.ADMIN, person2);

        userRepository.saveAll(Arrays.asList(user1,user2));

        String path1 = "Mar Portugues.txt";
        String path2 = "O Infante.txt";

        Post post1 = postPoemOfFPBuilder(path1);
        Post post2 = postPoemOfFPBuilder(path2);

        post1.setAuthor(user1);
        post2.setAuthor(user2);

        postRepository.saveAll(postBuilder(100, Arrays.asList(user1,user2)));

        Comment comment1 = new Comment(1L, "Gosto deste poema",LocalDateTime.now(), user1, post1);
        Comment comment2 = new Comment(2L, "Adoro deste poema",LocalDateTime.now(), user2, post1);
        Comment comment3 = new Comment(3L, "Adoro FP", LocalDateTime.now(), user2, post2);
        Comment comment4 = new Comment(4L, "Viva ao quinto imperio", LocalDateTime.now(), user1, post2);

        //commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4));
        
    }

    public List<Post> postBuilder(int numberOfPost, List<User> useres) {
        List<Post> list = new ArrayList<>();
        LocalDateTime dateOfPublication = LocalDateTime.of(2024, 1, 1, 9, 0);
        String title = "title Post_";
        String body = "body Post_";        

        for (int i = 0; i < numberOfPost; i++) {
            int userIndex = i % useres.size(); 
            long id = numberOfPost -i;
            list.add(new Post(id, title + i, body + i, dateOfPublication, "", useres.get(userIndex)));
            
            if (i % 2 == 0) {
                dateOfPublication = dateOfPublication.plusDays(-i);
            } else {
                dateOfPublication = dateOfPublication.plusDays(i);
            }
            
        }

        return list;
    }

    public Post postPoemOfFPBuilder (String path) throws IOException {
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

        Post post = new Post(null, title, text.toString(), LocalDateTime.now(), "Poesia");

        return post;
    }

}
