package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectDao extends CrudRepository<Project, Integer> {

    Project findFirstById(int id);
}
