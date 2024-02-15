package com.view.bunnyview.api.post;

import com.view.bunnyview.api.post.request.PostSaveRequest;
import com.view.bunnyview.application.post.PostService;
import com.view.bunnyview.entity.post.Post;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAllPosts() {
		return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findPostById(@PathVariable Long id) {
		Post post = postService.findById(id);
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		Post savedPost = postService.save(post);
		return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable Long id,
		@RequestBody PostSaveRequest postSaveRequest) {
		Post post = postService.findById(id);
		if (postSaveRequest != null) {
			final Post updatedPost = postService.update(post, postSaveRequest);
			return new ResponseEntity<>(updatedPost, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id) {
		try {
			postService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
