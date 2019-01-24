package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskDao extends CrudRepository<Task, Integer> {
}
