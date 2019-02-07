package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Comments;
import org.springframework.data.repository.CrudRepository;

public interface CommentsDao extends CrudRepository<Comments, Integer> {
}
