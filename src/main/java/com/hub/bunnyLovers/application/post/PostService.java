package com.hub.bunnyLovers.application.post;

import com.hub.bunnyLovers.api.post.request.PostSaveRequest;
import com.hub.bunnyLovers.application.common.CommonUtils;
import com.hub.bunnyLovers.entity.post.Post;
import com.hub.bunnyLovers.exception.BunnyException;
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

	public Post findById(Long id) throws Exception {

		if (id == null) {
			throw new NullPointerException();
		}

		return postRepository.findById(id)
			.orElseThrow(() -> new BunnyException("게시물이 존재하지 않습니다."));
	}


	public void addPost(Post post) {
		postRepository.save(post);
	}

	public void updatePost(PostSaveRequest postSaveRequest) throws Exception {
		Post findPost = findById(postSaveRequest.getPostId());

		Post post = Post.builder()
			.title(CommonUtils.getOrElse(postSaveRequest.getTitle(), findPost.getTitle()))
			.content(CommonUtils.getOrElse(postSaveRequest.getContent(), findPost.getContent()))
			.build();
		postRepository.save(post);
	}

	public void deleteById(Long id) {
		// 작성자 , 관리자가 맞는지 확인 추가 필요
		postRepository.deleteById(id);
	}

}
