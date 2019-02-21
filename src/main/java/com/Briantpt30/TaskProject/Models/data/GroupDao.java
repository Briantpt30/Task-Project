package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("groupRepository")
@Transactional
public interface GroupDao extends JpaRepository<Group, Integer> {
}
