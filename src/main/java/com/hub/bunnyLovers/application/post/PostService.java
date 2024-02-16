package com.hub.bunnyLovers.application.post;

import com.hub.bunnyLovers.api.post.request.PostSaveRequest;
import com.hub.bunnyLovers.api.post.request.PostUpdateRequest;
import com.hub.bunnyLovers.entity.post.Post;
import com.hub.bunnyLovers.exception.BunnyException;
import com.hub.bunnyLovers.repository.post.PostRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public List<Post> findPosts() {
		return postRepository.findPosts();
	}

	public Post findById(Optional<Long> postId) throws Exception {
		Long id = postId.orElseThrow(() -> new BunnyException("게시물이 존재하지 않습니다."));
		return postRepository.findById(id)
			.orElseThrow(() -> new BunnyException("게시물이 존재하지 않습니다."));
	}

	public void addPost(PostSaveRequest postSaveRequest) {
		Post post = Post.builder()
			.title(postSaveRequest.getTitle())
			.content(postSaveRequest.getContent())
			.build();
		postRepository.save(post);
	}

	public void updatePost(PostUpdateRequest postUpdateRequest) throws Exception {
		Post post = findById(Optional.ofNullable(postUpdateRequest.getPostId()));
		post.updateFieldsIfNotNull(postUpdateRequest.getTitle(), postUpdateRequest.getContent());
		postRepository.save(post);
	}

	public void deletePostById(Long id) {
		// 작성자 , 관리자가 맞는지 확인 추가 필요
		postRepository.deletePostById(id);
	}

}
