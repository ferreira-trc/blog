package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUserName(String userName);
    
    
}

