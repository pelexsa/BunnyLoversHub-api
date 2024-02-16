package com.hub.bunnyLovers.application.comment;

import com.hub.bunnyLovers.api.comment.request.CommentSaveRequest;
import com.hub.bunnyLovers.entity.comments.Comments;
import com.hub.bunnyLovers.entity.post.Post;
import com.hub.bunnyLovers.repository.comment.CommentRepository;
import com.hub.bunnyLovers.repository.post.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	public Comments getComment(Long id) {
		Comments comment = commentRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Comment not found with id " + id));
		//return convertToDto(comment);
		return null;
	}

	public void addComment(CommentSaveRequest commentSaveRequest) throws Exception {
		Post post = postRepository.findById(commentSaveRequest.getPostId())
			.orElseThrow(Exception::new);

		Comments comment = Comments.builder()
			.content(commentSaveRequest.getContent())
			.createdUser(commentSaveRequest.getCreatedUser())
			.post(post)
			.build();
		commentRepository.save(comment);
	}

	public void updateComment(CommentSaveRequest commentSaveRequest) throws Exception {
		Post post = postRepository.findById(commentSaveRequest.getPostId())
			.orElseThrow(Exception::new);

		Comments comment = Comments.builder()
			.content(commentSaveRequest.getContent())
			.createdUser(commentSaveRequest.getCreatedUser())
			.post(post)
			.build();

		commentRepository.save(comment);
	}

	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}

}
