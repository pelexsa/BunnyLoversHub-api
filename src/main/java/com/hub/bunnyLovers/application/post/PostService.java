package com.hub.bunnyLovers.application.post;

import com.hub.bunnyLovers.api.post.request.PostSaveRequest;
import com.hub.bunnyLovers.entity.post.Post;
import com.hub.bunnyLovers.repository.post.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public Post update(Post post, PostSaveRequest postSaveRequest) {
		if (postSaveRequest.getTitle() != null) {
			post.setTitle(postSaveRequest.getTitle());
		}

		if (postSaveRequest.getContent() != null) {
			post.setContent(postSaveRequest.getContent());
		}

		return postRepository.save(post);
	}

	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}

}
