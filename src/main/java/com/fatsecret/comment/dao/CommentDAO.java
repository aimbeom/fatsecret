package com.fatsecret.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	//댓글 추가
	public void insertComment(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("content") String content
			);
	
	//postId로 해당 게시글의 댓글들 리스트르 뽑기
	public List<Comment> selectCommentListByPostId(int postId);
	
	//댓글 삭제
	public void deleteCommentById(int id);
}
