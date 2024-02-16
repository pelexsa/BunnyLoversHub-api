package com.hub.bunnyLovers.application.post;

import com.hub.bunnyLovers.entity.post.Post;
import com.hub.bunnyLovers.repository.post.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class PostServiceTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	@Commit
	@DisplayName("게시물 저장용")
	void addPost() {
		Post post1 = Post.builder()
			.title("귀여운 토끼 사진 공유")
			.content("오늘은 귀여운 토끼의 사진을 공유해봅니다.")
			.createdUser("user1")
			.build();

		Post post2 = Post.builder()
			.title("토끼를 위한 건강한 먹이 추천")
			.content("토끼를 위한 건강한 먹이 추천을 알아보세요.")
			.createdUser("user2")
			.build();

		Post post3 = Post.builder()
			.title("토끼를 위한 쾌적한 환경 조성 방법")
			.content("토끼를 편안하고 쾌적한 환경에서 키우는 방법을 공유합니다.")
			.createdUser("user3")
			.build();

		postRepository.save(post1);
		postRepository.save(post2);
		postRepository.save(post3);
	}
	
}