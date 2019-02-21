package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("taskRepository")
public interface TaskDao extends JpaRepository<Task, Integer> {
}
