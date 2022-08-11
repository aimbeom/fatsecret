package com.fatsecret.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.common.FileManagerService;
import com.fatsecret.post.dao.PostDAO;
import com.fatsecret.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private FileManagerService fileManager;
	
	@Autowired
	PostDAO postDAO;
	
	//게시글 추가
	public void addPost(int userId, String userNickname, String title, String content, MultipartFile file) {
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
}
