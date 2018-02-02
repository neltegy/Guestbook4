package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookDao guestbookdao;
	
	@RequestMapping("/list")
	public String getlist(Model model) {
		System.out.println("/list");
		
		List<GuestBookVo> list = guestbookdao.getlist();
		
		model.addAttribute("volist", list);
		
		return "list";
	}
	
	@RequestMapping(value="/deleteform",method=RequestMethod.GET)
	public String deleteform() {
		System.out.println("/deleteform");
		
		return "deleteform";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo guestbookvo) {
		System.out.println("/delete");
		
		guestbookdao.delete(guestbookvo);
		
		return "redirect:/list";
	}
	
}
