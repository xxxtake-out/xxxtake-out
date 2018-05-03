package com.bunfly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bunfly.model.User;
import com.bunfly.service.impl.UserServiceImpl;
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl us;
	@RequestMapping("/save")
	public ModelAndView saveUser(HttpServletRequest request,HttpServletResponse response){
		System.out.println("-----------");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setCid(2);
		us.saveUser(u);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index.jsp");
		return mav;
	}
}
