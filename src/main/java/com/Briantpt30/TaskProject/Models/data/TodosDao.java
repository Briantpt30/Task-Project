package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("todosRepository")
public interface TodosDao extends JpaRepository<Todos, Integer> {

    Todos findAllByTask(int taskId);
}
