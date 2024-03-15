package jp.ac.ohara.schedule.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.ac.ohara.schedule.model.SignupForm;
import jp.ac.ohara.schedule.model.UserBook;
import jp.ac.ohara.schedule.service.UserBookService;
 
@Controller
public class SignupController {
	@Autowired
	UserBookService userBookService;
    @GetMapping("/signup/")
    public String getSignUp(@ModelAttribute SignupForm form, Model model) {
    	model.addAttribute("signupForm", form);
        return "signup";
    }
    @GetMapping("/signupcomplete/")
    public String getSignUpComplete(@ModelAttribute SignupForm form, Model model) {
    	model.addAttribute("signupForm", form);
        return "signupcomplete";
    }
 
    @PostMapping("/signup/")
    public String postSignUp(@ModelAttribute @Validated UserBook userBook,SignupForm form, BindingResult bindingResult, Model model) {
    	this.userBookService.save(userBook);
    	//入力を失敗した場合、ユーザー登録画面に戻る
    	if (bindingResult.hasErrors()) {
    		return getSignUp(form, model);
    	}
    	//formの中身をコンソールに表示
    	System.out.println(form);
    	return "redirect:/signupcomplete/";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/"; // Redirect to the home page after logout
    }
}