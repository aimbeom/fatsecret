package com.fatsecret.comment.model;

import com.fatsecret.user.model.User;

public class CommentCard {
	
	private User user;
	private Comment comment;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	

}
