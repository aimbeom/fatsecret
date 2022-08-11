package com.fatsecret.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.comment.dao.CommentDAO;
import com.fatsecret.comment.model.Comment;
import com.fatsecret.comment.model.CommentCard;
import com.fatsecret.user.bo.UserBO;
import com.fatsecret.user.model.User;

@Service
public class CommentBO {
	
	@Autowired
	CommentDAO commentDAO;
	
	@Autowired
	UserBO userBO;
	
	//댓글 추가
	public void addComment(int userId, int postId, String content) {
		
		commentDAO.insertComment(userId, postId, content);
	}
	
	// (1) postId로 게시글의 댓글 가져오기
	public List<Comment> getCommentList(int postId){
		
		return commentDAO.selectCommentListByPostId(postId);
	}
	
	//CommentCard 만들기
	public List<CommentCard> generateCommentCardView(int postId){
		List<CommentCard> commentCardList = new ArrayList<>();
		
		//(1) 메서드의 값을 대입
		List<Comment> commentList = getCommentList(postId);
		
		for(Comment comment : commentList) {
			CommentCard commentCard = new CommentCard();
			//댓글 쓴 유저 뽑기
			int userId = comment.getUserId();
			User user = userBO.getUserByUserId(userId);
			
			//CommentCard에 하나씩 세팅하기
			commentCard.setComment(comment);
			commentCard.setUser(user);
			
			//commentCardList에 추가
			commentCardList.add(commentCard);
		}
		
		return commentCardList;
	}
	
	//댓글 삭제
	public void deleteCommentById(int id) {
		
		commentDAO.deleteCommentById(id);
	}
}
