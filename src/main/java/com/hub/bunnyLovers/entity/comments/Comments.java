package com.hub.bunnyLovers.entity.comments;

import com.hub.bunnyLovers.entity.BaseTimeEntity;
import com.hub.bunnyLovers.entity.post.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
public class Comments extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;

	private String content;

	@ColumnDefault("'N'")
	@Comment("삭제 여부")
	@Column(length = 1, nullable = false)
	private String delYn;

	@Column(length = 45)
	@Comment("등록자")
	private String createdUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Post post;

	@Builder
	public Comments(String content, String createdUser, Post post) {
		this.content = content;
		this.createdUser = createdUser;
		this.post = post;
	}

}
