package com.hub.bunnyLovers.api.post;

import com.hub.bunnyLovers.api.post.request.PostSaveRequest;
import com.hub.bunnyLovers.application.post.PostService;
import com.hub.bunnyLovers.entity.post.Post;
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
	public ResponseEntity<Post> findPostById(@PathVariable Long id) throws Exception {
		Post post = postService.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> addPost(@RequestBody Post post) {
		postService.addPost(post);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> updatePost(@RequestBody PostSaveRequest postSaveRequest)
		throws Exception {
		postService.updatePost(postSaveRequest);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id) {
		postService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
