package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.users.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByTaskTaskId(Long taskId);
}
