package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("projectRepository")
public interface ProjectDao extends JpaRepository<Project, Integer> {

    Project findFirstById(int id);
}
