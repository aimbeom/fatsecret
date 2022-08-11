package com.fatsecret.timeline.model;

import java.util.List;

import com.fatsecret.comment.model.CommentCard;
import com.fatsecret.post.model.Post;
import com.fatsecret.user.model.User;

public class CardView {
	
	private User user; //유저 정보
	private Post post; //게시물 정보
	private List<CommentCard> commentCardList; //댓글 목록
	
	public List<CommentCard> getCommentCardList() {
		return commentCardList;
	}
	public void setCommentCardList(List<CommentCard> commentCardList) {
		this.commentCardList = commentCardList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
}
