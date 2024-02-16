package com.hub.bunnyLovers.api.post.request;

import lombok.Getter;

@Getter
public class PostSaveRequest {

	private Long postId;
	private String title;
	private String content;

}
