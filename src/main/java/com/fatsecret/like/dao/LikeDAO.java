package com.fatsecret.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	
	//좋아요 유무 파악
	public boolean existLikeByPostIdAndUserId(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
	//좋아요 추가
	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
	//좋아요 삭제
	public void deleteLikeByPostIdAndUserId(
			@Param("postId") int postId,
			@Param("userId") Integer userId);

	//좋아요 갯수 가져오기
	public int selectLikeByPostIdUserId(int postId);
	
	//해당 게시글의 좋아요 삭제
	public void deleteLikeListByPostId(int postId);
}