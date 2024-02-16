package com.hub.bunnyLovers.entity.post;

import com.hub.bunnyLovers.application.common.CommonUtils;
import com.hub.bunnyLovers.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;

	@Setter
	private String title;

	@Setter
	private String content;

	private String delYn;

	private Long viewCount;

	@Column(length = 45, nullable = false)
	@Comment("등록자")
	private String createdUser;

	public void updateFieldsIfNotNull(String title, String content) {
		this.title = CommonUtils.getOrElse(title, this.title);
		this.content = CommonUtils.getOrElse(content, this.content);
	}

	@Builder
	public Post(String title, String content, String createdUser) {
		this.title = title;
		this.content = content;
		this.createdUser = createdUser;
		this.delYn = "N";
		this.viewCount = 0L;
	}

}
