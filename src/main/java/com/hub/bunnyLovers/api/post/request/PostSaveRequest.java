package com.hub.bunnyLovers.api.post.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class PostSaveRequest {

	private Long postId;

	@NotNull
	@NotEmpty
	private String title;
	
	@NotNull
	@NotEmpty
	private String content;
	private String createdUser;

}
