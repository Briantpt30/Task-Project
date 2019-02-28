package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("commentsRepository")
public interface CommentsDao extends JpaRepository<Comments, Integer> {

    Comments findAllByTask(int taskId);
}
