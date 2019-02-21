package com.Briantpt30.TaskProject.Service;

import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.RoleDao;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleDao.findAll()));
        userDao.save(user);
    }
    @Override
    public User findByUsername(String username){
        return userDao.findByEmail(username);
    }
    @Override
    public User findById(int id){
        return userDao.findFirstById(id);
    }
}
