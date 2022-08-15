package com.fatsecret.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.like.dao.LikeDAO;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	public void like(int userId, int postId) {
		if (likeDAO.existLikeByPostIdAndUserId(postId, userId)) {
			// 좋아요가 있으면
			likeDAO.deleteLikeByPostIdAndUserId(postId, userId);
		} else {
			// 좋아요가 없으면
			likeDAO.insertLike(postId, userId);
		}
	}
	
	public int getLikeCount(int postId) {
		
		return likeDAO.selectLikeByPostIdUserId(postId);
	}
	
	public boolean existLike(int postId, Integer userId) {
		
		return likeDAO.existLikeByPostIdAndUserId(postId, userId);
	}
	
	//timeline card의 좋아요 삭제를 위해 postId로 해당 게시글의 좋아요 삭제
	public void deleteLikeListByPostId(int postId) {
		
		likeDAO.deleteLikeListByPostId(postId);
	}
	
}
