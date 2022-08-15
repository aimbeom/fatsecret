package com.fatsecret.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//		/Users/jojoonbeom/FatSecret/workspace/images

@Component
public class FileManagerService {
	
	public final static String FILE_UPLOAD_PATH =  "/Users/jojoonbeom/FatSecret/workspace/images/";
	 //input : MultipartFile, userLoginId
	 //output : String path
		public String saveFile(String userNickname, MultipartFile file) {
			// 파일명이 겹치지 않게 하기 위해 userLoginId, 현재시간을 경로에 붙여준다.
			// 파일 디렉토리(폴더) 경로 예: userLoginId_현재시간/이미지파일 명 = aaaa_135465413/sun.png
			
			String directoryName = userNickname + "_" + System.currentTimeMillis() + "/";
			String filePath= FILE_UPLOAD_PATH + directoryName;
			
			// 디렉토리 만들기
			File directory = new File(filePath);
			if(directory.mkdir() == false) {
				return null;
			}
			
			//파일 업로드: byte 단위로 업로드 한다.
			try {
				byte[] bytes = file.getBytes();	//선택한 파일을 가져온다
				Path path = Paths.get(filePath + file.getOriginalFilename()); //파일명을 영어로 만들게(파일명을 지어주는 단계)
				Files.write(path, bytes);	// 파일 업로드
				
				// 이미지 업로드 성공시 Path를 리턴한다.	(WebMvcConfig에서 매핑한 이미지 path)
				// 예) http://localhost/images/aimbeom_135465413/sun.png
				return "/images/"+directoryName + file.getOriginalFilename();	//파일명은 path랑 일치하게
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		public void deleteFile(String imagePath) throws IOException {
			// imagePath: /images/aaaa_1658734800740/화면 캡처 2022-06-09 155425.png
			// "D:\\jjb2\\memo\\workspace\\images/"    /images/aaaa_1658734800740/화면 캡처 2022-06-09 155425.png
			// 전체 경로와 imagePath간의 중복되는 /images/ 문자열을 제거한 후 실제 저장 경로를 찾는다.
		
			imagePath = imagePath.replace("/images/", "");	//"D:\\jjb2\\memo\\workspace\\images/aaaa_1658734800740/화면 캡처 2022-06-09 155425.png"
			Path path = Paths.get(FILE_UPLOAD_PATH + imagePath);
			if(Files.exists(path)) { //이미지 파일이 있으면 삭제 (파라미터 2개중 한개 삭제)
				Files.delete(path);
			}
			
			// 디렉토리(폴더) 삭제
			path = path.getParent();
			if(Files.exists(path)){
				Files.delete(path);
			}
		}
	}
