package com.Briantpt30.TaskProject.Service;

import com.Briantpt30.TaskProject.Models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User findById(int id);
}
