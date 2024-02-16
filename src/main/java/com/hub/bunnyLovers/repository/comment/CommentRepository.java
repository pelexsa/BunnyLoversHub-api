package com.hub.bunnyLovers.repository.comment;

import com.hub.bunnyLovers.entity.comments.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long>, CommentRepositoryCustom {

}
