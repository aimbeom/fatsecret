package com.fatsecret.timeline.model;

import java.util.List;

import com.fatsecret.comment.model.CommentCard;
import com.fatsecret.post.model.Post;
import com.fatsecret.user.model.User;

public class CardView {
	
	private User user; //유저 정보
	private Post post; //게시물 정보
	private List<CommentCard> commentCardList; //댓글 목록
	private boolean filledLike; // 로그인한 내가 좋아요를 누른 여부
	private int likeCount; // 좋아요 개수
	
	public boolean isFilledLike() {
		return filledLike;
	}
	public void setFilledLike(boolean filledLike) {
		this.filledLike = filledLike;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
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
