package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Todos;
import org.springframework.data.repository.CrudRepository;

public interface TodosDao extends CrudRepository<Todos, Integer> {
}
