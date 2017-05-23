package com.sifox.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sifox.service.ShameDeskService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HomeController {
	
	@Autowired
	ShameDeskService cService;
	
	@RequestMapping(value = {"/","/home"}, method = GET)
	public ModelAndView home(Model model) 
	{
		ModelAndView modelView = new ModelAndView();
//		List<String> abbreviations = cService.nameList();
		modelView.setViewName("home");
//		modelView.addObject("currencies", abbreviations);
		return modelView;
	}
	
	@RequestMapping(value = {"/desk"}, method = GET)
	public ModelAndView getMainView(Model model) 
	{
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("appmainview");
		return modelView;
	}
	
}
