package com.fatsecret.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatsecret.post.bo.PostBO;
import com.fatsecret.post.model.Post;
import com.fatsecret.user.bo.UserBO;
import com.fatsecret.user.model.User;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	UserBO userBO;
	
	@Autowired
	PostBO postBO;
	
	/**
	 * 회원가입 페이지
	 * @param model
	 * @return
	 */
//	http://localhost:8080/user/sign_up_view
	@RequestMapping("/sign_up_view")
	public String joinView(Model model) {
		model.addAttribute("viewName", "user/sign_up");
		
		return	"template/layout";
	}
	
	
	/**
	 * 로그인 페이지
	 * @param model
	 * @return
	 */
//	http://localhost:8080/user/sign_in_view
	@RequestMapping("/sign_in_view")
	public String loginView(Model model) {
		model.addAttribute("viewName", "user/sign_in");
		
		return	"template/layout";
	}
	
	/**
	 * 권장칼로리 알림 페이지
	 * @param model
	 * @return
	 */
//	http://localhost:8080/user/kcal_informed_view
	@RequestMapping("/kcal_informed_view")
	public String kcalInformedView(Model model, HttpSession session) {
		
		User user = userBO.getCurrentUser();
		
//		int userId = (int) session.getAttribute("userId");
		
		int recommendedKcal = userBO.calculateKcal(user.getId());
		
		model.addAttribute("viewName", "user/kcal_informed");
		model.addAttribute("recommendedKcal", recommendedKcal);
		
		return "template/layout";
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
//	http://localhost:8080/user/sign_out
	@RequestMapping("/sign_out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userEamil");
		session.removeAttribute("userName");
		session.removeAttribute("userWeight");
		session.removeAttribute("userpurposeWeight");
		session.removeAttribute("userImage");
		session.removeAttribute("recommendedKcal");
		
		return "redirect:/timeline/timeline_view";
	}
	
	
	/**
	 * 마이 페이지
	 * @param model
	 * @return
	 */
//	http://localhost:8080/user/my_page_view
	@RequestMapping("/my_page_view")
	public String myPage(Model model, HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		List<Post> postList = postBO.getPostListByUserId(userId);
		
		User user = userBO.getUserByUserId(userId);
		
		model.addAttribute("viewName", "user/my_page");
		model.addAttribute("postList", postList);
		model.addAttribute("user", user);
		
		return "template/layout2";
	}
	
	/**
	 * 내 체중 수정 페이지
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/user/my_wight_update_view
	@RequestMapping("/my_weight_update_view")
	public String weightUpdatePage(Model model, HttpSession session) {
		
//		int userId = (int) session.getAttribute("userId");
		
		model.addAttribute("viewName", "user/weight_update");
		
		return "template/layout2";
	}
	
	
	
}
