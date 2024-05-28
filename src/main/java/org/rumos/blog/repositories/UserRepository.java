package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    
}

