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
	
	//timeline card 삭제를 위해 postId로 리스트 가져오기
	public Post selectPostListByPostId(int postId);
	
	//timeline card 삭제를 위해 postId로 리스트 삭제하기
	public void deletePostListByPostId(int postId);
	
	//글 수정
	public int updatePostByPostIdAndUserId(
			@Param("postId") int postId,
			@Param("userId") int userId,
			@Param("title") String title,
			@Param("content") String content,
			@Param("imagePath") String imagePath
			);
	
	//마이페이지에 뿌릴 글목록 가져오기
	public List<Post> getPostListByUserId(Integer userId);
}
