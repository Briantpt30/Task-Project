package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findByEmail(String email);
    User findByPassword(String password);
    Boolean existsByEmail(String email);
    Boolean existsByPassword(String password);
    User findFirstById(int id);

}
