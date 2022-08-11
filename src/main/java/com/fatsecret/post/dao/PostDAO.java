package com.fatsecret.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.post.model.Post;

@Repository
public interface PostDAO {
	
	//게시글 추가
	public void insertPost(
			@Param("userId") int userId,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath
			);
	
	//timelineBO에 뿌릴 게시글 가져오기
	public List<Post> selectPostList();
}
