package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.entities.User;

public interface UserService {
    public List<User> findAll();
    public User findById(Long id);
    public User add(User user);
    public User update(Long postId, User userUpdated);
    public void delete(Long id);
}
