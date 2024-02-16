package com.hub.bunnyLovers.api.post;

import com.hub.bunnyLovers.api.post.request.CommentSaveRequest;
import com.hub.bunnyLovers.application.post.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentsService;

	@PostMapping
	public ResponseEntity<Void> addComment
		(@RequestBody CommentSaveRequest commentSaveRequest) throws Exception {
		commentsService.addComment(commentSaveRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> updateComment
		(@RequestBody CommentSaveRequest commentSaveRequest) throws Exception {
		commentsService.updateComment(commentSaveRequest);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
		commentsService.deleteComment(id);
		return ResponseEntity.ok().build();
	}

}
