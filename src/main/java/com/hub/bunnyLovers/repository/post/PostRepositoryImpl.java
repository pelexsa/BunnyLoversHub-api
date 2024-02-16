package com.hub.bunnyLovers.repository.post;

import com.hub.bunnyLovers.entity.post.Post;
import com.hub.bunnyLovers.entity.post.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

	private final JPAQueryFactory query;
	private final EntityManager entityManager;

	@Override
	public List<Post> findPosts() {
		QPost qPost = new QPost("q1");
		return query
			.selectFrom(qPost)
			.where(qPost.delYn.eq("N"))
			.fetch();
	}

	@Override
	public void deletePostById(Long id) {
		QPost qPost = new QPost("q1");
		query
			.update(qPost)
			.set(qPost.delYn, "Y")
			.where(qPost.id.eq(id))
			.execute();
	}

}
