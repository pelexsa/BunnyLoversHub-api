package com.hub.bunnyLovers.post;

import com.hub.bunnyLovers.application.post.PostService;
import com.hub.bunnyLovers.entity.post.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PostControllerTest {

	@Autowired
	private PostService postService;

	@Test
	@Commit
	void addPost() {
		Post post1 = Post.builder()
			.title("귀여운 토끼 사진 공유")
			.content("오늘은 귀여운 토끼의 사진을 공유해봅니다.")
			.build();

		Post post2 = Post.builder()
			.title("토끼를 위한 건강한 먹이 추천")
			.content("토끼를 위한 건강한 먹이 추천을 알아보세요.")
			.build();

		Post post3 = Post.builder()
			.title("토끼를 위한 쾌적한 환경 조성 방법")
			.content("토끼를 편안하고 쾌적한 환경에서 키우는 방법을 공유합니다.")
			.build();

		postService.addPost(post1);
		postService.addPost(post2);
		postService.addPost(post3);
	}

}