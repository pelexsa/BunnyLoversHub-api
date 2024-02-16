package com.hub.bunnyLovers.api.post.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class CommentSaveRequest {

	private String content;
	private String createdUser;

	@NotNull
	private Long postId;

}
