package com.bunfly.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bunfly.model.Merchant;
import com.bunfly.model.User;
import com.bunfly.service.impl.UserServiceImpl;
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl us;
	private static int i = 000;
	@RequestMapping("/save")
	public String save(MultipartFile file,Merchant mer) throws IllegalStateException, IOException{
		i++;
		
		String path = "/cid";
		System.out.println(file);
		String filename = file.getOriginalFilename();
		String ind = filename.substring(filename.lastIndexOf(".")+1);
		System.out.println(ind);
		String newName = i+"."+ind;
		System.out.println(newName);
		File f = new File(path,newName);
		file.transferTo(f);
		return "/index.jsp";
	}
}
