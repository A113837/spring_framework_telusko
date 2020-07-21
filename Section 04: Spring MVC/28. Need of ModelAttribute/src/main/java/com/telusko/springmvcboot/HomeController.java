package com.telusko.springmvcboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page requsted");
		return "index";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1")int i,@RequestParam("num2") int j, ModelMap m)
	{
		//ModelAndView mv = new ModelAndView("result");
		//mv.setViewName("result");
		
		int num3 = i+j;
		
		//session.setAttribute("num3", num3);
		
		m.addAttribute("num3", num3);
		return "result";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(@RequestParam("aid")int aid,@RequestParam("aname") String aname, Model m) {
		
		Alien a = new Alien();
		a.setAid(aid);
		a.setAname(aname);
		
		m.addAttribute("alien", a);
		return "result";
	}
}
