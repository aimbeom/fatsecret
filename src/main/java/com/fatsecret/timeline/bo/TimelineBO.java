package com.fatsecret.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.comment.bo.CommentBO;
import com.fatsecret.comment.model.CommentCard;
import com.fatsecret.post.bo.PostBO;
import com.fatsecret.post.model.Post;
import com.fatsecret.timeline.model.CardView;
import com.fatsecret.user.bo.UserBO;
import com.fatsecret.user.model.User;

@Service
public class TimelineBO {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private CommentBO commentBO;
	
	public List<CardView> createCardView(){
		List<CardView> cardList = new ArrayList<CardView>();
		
		// 글 목록을 가져온다
		List<Post> postList = postBO.getPostList();
		
		// 가져온 글 목록을 하나의 카드별로 넣어준다
		for(Post post : postList) {
			CardView card = new CardView();
			
			//게시글을 작성한 유저의 정보를 넣어준다
			User user = userBO.getUserByUserId(post.getUserId());
			
			
			//card에 게시물의 정보와 게시글 작성자의 정보를 넣는다
			card.setUser(user);
			card.setPost(post);
			
			//post에서 Id값을 꺼내 매개로 받아 commentCard 호출
			List<CommentCard> commentCardList = commentBO.generateCommentCardView(post.getId());
			card.setCommentCardList(commentCardList);
			//종합한 card를 cardList에 넣는다
			cardList.add(card);
		}
		
		return cardList;
	}
}
