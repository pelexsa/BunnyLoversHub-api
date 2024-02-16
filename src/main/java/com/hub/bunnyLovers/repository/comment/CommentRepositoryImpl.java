package com.hub.bunnyLovers.repository.comment;

import com.hub.bunnyLovers.entity.comments.Comments;
import com.hub.bunnyLovers.entity.comments.QComments;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

	private final JPAQueryFactory query;
	private final EntityManager entityManager;

	@Override
	public void update(Comments comment) {
		QComments qComments = new QComments("q1");
		JPAUpdateClause update = new JPAUpdateClause(entityManager, qComments);

	}

}
