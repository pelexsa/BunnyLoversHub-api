package com.hub.bunnyLovers.repository.post;

import com.hub.bunnyLovers.entity.post.Post;
import java.util.List;

public interface PostRepositoryCustom {

	public List<Post> findPosts();

	public void deletePostById(Long id);

}
