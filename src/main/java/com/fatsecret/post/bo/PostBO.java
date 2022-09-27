package com.fatsecret.post.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.comment.bo.CommentBO;
import com.fatsecret.common.FileManagerService;
import com.fatsecret.like.bo.LikeBO;
import com.fatsecret.post.dao.PostDAO;
import com.fatsecret.post.model.Post;

@Service
public class PostBO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FileManagerService fileManager;
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	CommentBO commentBO;
	
	@Autowired
	LikeBO likeBO;
	
	//게시글 추가
	public void addPost(Integer userId, String userNickname, String title, String content, MultipartFile file) {
		
		String imagePath = null;

		// 파일이 있으면 파일 업로드 => path 리턴 받음
		if (file != null) {
			imagePath = fileManager.saveFile(userNickname, file);
		}
		
		//dao 전송
		postDAO.insertPost(userId, title, content, imagePath);
		
	}
	
	// timelinBO에 뿌릴 post들을 가져오기
	public List<Post> getPostList(){
		
		return postDAO.selectPostList();
	}
	
	// 글 수정 페이지에 해당 게시글 가져오기
	public Post getPostListByPostId(int postId) {

		return postDAO.selectPostListByPostId(postId);
	}
	
	// timelinecard 삭제를 위해 postId로 리스트 삭제하기
	public void deletePostListByPostId(int postId) {
		
		postDAO.deletePostListByPostId(postId);
	}
	
	//timeline card 삭제
	public void deletePostByPostIdUserId(int postId, Integer userId) {
		// 삭제할 글을 셀렉트 해온다.
		logger.info("updatePost postId:{}", postId);

		Post post = getPostListByPostId(postId);
		if (post == null) {
			logger.error("[delete post] 삭제할 게시물이 없습니다. postId:{}", postId);
		}
		// 이미지가 있으면 이미지 삭제
		if (post.getImagePath() != null) {
			// 기존 이미지 삭제
			try {
				fileManager.deleteFile(post.getImagePath());
			} catch (Exception e) {
				logger.error("이미지 삭제 실패");
			}
		}
	// 글 삭제
		if(post.getContent() != null) {
			deletePostListByPostId(postId);
		}
	// 댓글들 삭제 by postId
		commentBO.deleteCommentByPostId(postId);
		
	// 좋아요 삭제 by postId
		likeBO.deleteLikeListByPostId(postId);
	}
	
	//글 수정
	public int updatePost(Integer userId, String userNickname, int postId,
			String title, String content, MultipartFile file) {
		
		// 기존에 저장된 글을 가져와본다
		logger.info("updatePost postId:{}", postId);
		
		Post post = getPostListByPostId(postId);
		if(post == null) {
			logger.error("[update post] 수정할 게시물이 없습니다. postId:{}", postId);
			return 0;
		}
		
		// 업로드 할 파일이 있는지 본 후 서버에 업로드하고 imagePath를 받아온다
		// 업로드 할 파일이 없는경우 수정하지 않음
		String imagePath = null;
		if (file != null) {
			// 업로드 할 파일이 있는지 본 후 서버에 업로드하고 imagePath를 받아온다
			imagePath = fileManager.saveFile(userNickname, file);
		
			// 새로 업로드된 이미지가 성공하면 기존 이미지 삭제(기존 이미지가 있을 때에만)
			if(imagePath != null && post.getImagePath() != null) {
				// 기존 이미지 삭제
				try {
					fileManager.deleteFile(post.getImagePath());
				} catch (Exception e) {
					logger.error("이미지 삭제 실패");
				}
			}
		}
		return postDAO.updatePostByPostIdAndUserId(postId, userId, title, content, imagePath);
	}
	
	//마이페이지에 뿌려줄 유저 id를 인자로 게시한 게시물들을 가져온다
	public List<Post> getPostListByUserId(Integer userId) {
		
		return postDAO.getPostListByUserId(userId);
	}
	
}
