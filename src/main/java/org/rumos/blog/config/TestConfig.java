package org.rumos.blog.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.rumos.blog.model.entities.Category;
import org.rumos.blog.model.entities.Comment;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.model.enums.Role;
import org.rumos.blog.repositories.CategoryRepository;
import org.rumos.blog.repositories.CommentRepository;
import org.rumos.blog.repositories.PersonRepository;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person(null, "Tiago Ferreira", "tiago@ex.pt", LocalDate.now());
        Person person2 = new Person(null, "Rute Andrade","rute@ex.pt", LocalDate.now());

        personRepository.saveAll(Arrays.asList(person1,person2));

        User user1 = new User(null,"@ferreira_trc", new BCryptPasswordEncoder().encode("1234"), Role.ADMIN, person1);
        User user2 = new User(null,"@andrade_rm", new BCryptPasswordEncoder().encode("1234"), Role.ADMIN, person2);

        userRepository.saveAll(Arrays.asList(user1,user2));

        personUserBuilder(10);

        String path1 = "Mar Portugues.txt";
        String path2 = "O Infante.txt";

        //Post post1 = postPoemOfFPBuilder(path1);
        //Post post2 = postPoemOfFPBuilder(path2);

        //post1.setAuthor(user1);
        //post2.setAuthor(user2);

        postBuilder(2, Arrays.asList(user1,user2));

        //Comment comment1 = new Comment(null, "Gosto deste poema", user1, post1);
        //Comment comment2 = new Comment(null, "Adoro deste poema", user2, post1);
        //Comment comment3 = new Comment(null, "Adoro FP", user2, post2);
        //Comment comment4 = new Comment(null, "Viva ao quinto imperio", user1, post2);

        //commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4));
        
    }

    public void personUserBuilder(int numberOfUseres) {
        String personName = "person_";
        String userName = "user_";
        String email = "@ex.pt";

        for (int i = 0; i < numberOfUseres; i++) {
            Person person = new Person(null, personName + i, personName + i + email, LocalDate.now());
            User user = new User(null, userName + i, new BCryptPasswordEncoder().encode("1234") , Role.USER, person);

            personRepository.save(person);
            userRepository.save(user);
        }

    }

    public void postBuilder(int numberOfPost, List<User> useres) {        
        String title = "title Post_";
        String body = "body Post_";
        
        List<Category> categories = categoryBuilder(10);
        categoryRepository.saveAll(categories);        

        for (int i = 0; i < numberOfPost; i++) {
            int userIndex = i % useres.size();
            Post post = new Post(null, title + i, body + i, null /*categories.get(numberOfPost % 10)*/, useres.get(userIndex)); 
            post.setCategory(categoryRepository.findById(1L).get());                  
            postRepository.save(post);
            List<Comment> postComments = commentBuilder(2, useres, post);
            commentRepository.saveAll(postComments);
        }

        
    }

    /*
        public Post postPoemOfFPBuilder(String path) throws IOException {
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

            Post post = new Post(null, title, text.toString(),"Poesia");

            return post;
        }
     * 
     */

    public List<Comment> commentBuilder(int numberOfComments, List<User> useres, Post post) {  
        List<Comment> list = new ArrayList<>();      
        String commentContent = "comment_";

        for (int i = numberOfComments; i > 0; i--) {
            int userIndex = i % useres.size(); 
            Comment comment = new Comment(null, commentContent + i, useres.get(userIndex), post);    
            list.add(comment);        
        }

        return list;
    }

    public List<Category> categoryBuilder(int numberOfCategory) {
        List<Category> list = new ArrayList<>();      
        String category = "category_";

        for (int i = numberOfCategory; i > 0; i--) {               
            list.add(new Category(null, category + i));        
        }

        return list;
    }
}
