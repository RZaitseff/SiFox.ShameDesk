package com.sifox.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sifox.entity.UserProfile;
import com.sifox.entity.User;
import com.sifox.service.SecurityService;
import com.sifox.service.UserService;
import com.sifox.utils.AjaxResult;

@Controller
public class UserController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/settings", method = GET)
	public String settings() {
		return "settings";
	}
	
	@RequestMapping(value="/settings/user/list")
	@ResponseBody
	public AjaxResult userList() {
		AjaxResult result = new AjaxResult();
		try {
			result.setData(userService.list());
			result.setSuccess(true);
	        result.setMessage("User List has empfangen");
		} catch(Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping(value="/settings/user")
	@ResponseBody
	public AjaxResult user() {
		AjaxResult result = new AjaxResult();
		User user =securityService.getCurrentUser();
		try {
	        result.setSuccess(true);
	        result.setMessage("User " + user.getLogin() + " was red");
	        result.setData(userService.read(user.getId()));
		} catch(Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			result.setData(-1);
		}
		
		return result;
	}

	@RequestMapping(value="/settings/user/add")
	@ResponseBody
	public AjaxResult addUser( @RequestParam("login") String login, @RequestParam("password") String password ) {
		AjaxResult result = new AjaxResult();
		User user =new User();
		user.setLogin(login);
		user.setPassword(password);
		try {
			int generatedCategoryID;
//			generatedCategoryID = userService.add(user);
			
	        result.setSuccess(true);
	        result.setMessage("User " + login + " was created");
//	        result.setData(generatedCategoryID);
		} catch(Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			result.setData(-1);
		}
		
		return result;
	}
	
	@RequestMapping(value="/settings/user/edit")
	@ResponseBody
	public AjaxResult updateUser(@RequestParam("login") String login, @RequestParam("password") String password) {
		User user = securityService.getCurrentUser();
		AjaxResult result = new AjaxResult();
//		try {
//			 if(userService.update(new User(user.getId(), login, password))) {
//				 result.setSuccess(true);
//			     result.setMessage("User login/passwoed was succesfully changed");
//			     result.setData(user.getId());
//			     securityService.getCurrentUser().setLogin(login);
//			     securityService.getCurrentUser().setPassword(password);
//			 } else {
//				 result.setSuccess(false);
//			     result.setMessage("User name/password wasn't changed");
//			     result.setData(-1);
//			 }
//		} catch(Exception e) {
//			result.setSuccess(false);
//			result.setMessage(e.getMessage());
//			result.setData(-1);
//		}
		
		return result;
	}
	
	@RequestMapping(value="/settings/user/delete")
	@ResponseBody
	public AjaxResult deleteUser() {
		AjaxResult result = new AjaxResult();
		User user = securityService.getCurrentUser();
		int id = user.getId();
//		try {
//			if(userService.delete(id)) {
//			 result.setSuccess(true);
//		     result.setMessage("User id=" + id +" was succesfully deleted");
//		     result.setData(id);
//			} else {
//				 result.setSuccess(false);
//			     result.setMessage("Category wasn't deleted");
//			     result.setData(-1);				
//			}
//		} catch(Exception e) {
//			result.setSuccess(false);
//			result.setMessage(e.getMessage());
//			result.setData(-1);
//		}
		
		return result;
	}

	@RequestMapping(value="/settings/user/profile")
	@ResponseBody
	public AjaxResult userProfile() {

		AjaxResult result = new AjaxResult();
		User user = securityService.getCurrentUser();
		int id = user.getId();
		UserProfile profile = null;
//		try {
//			profile = userService.getUserProfile(id).entity().getUserProfile();
//			result.setSuccess(true);
//		    result.setMessage("Profile for User " + user.getLogin() +" was succesfully read");
//		    result.setData(profile);
//		} catch(Exception e) {
//			result.setSuccess(false);
//			result.setMessage(e.getMessage());
//		     result.setData(-1);
//		}
		
		return result;
	}

	@RequestMapping(value="/settings/user/profile/update")
	@ResponseBody
	public AjaxResult userProfileUpdate(
			  @RequestParam("fullName") String fullName, @RequestParam("email") String email
			, @RequestParam("cell")     String cell,     @RequestParam("notify") Boolean notify) {

		AjaxResult result = new AjaxResult();
		User user = securityService.getCurrentUser();
		int id = user.getId();
		UserProfile profile = new UserProfile();
		profile.setId(id);
//		profile.setFullName(fullName);
//		profile.setEmail(email);
//		profile.setCell(cell);
//		profile.setNotify(notify);
//		user.setUserProfile(profile);
//		try {
//			if(userService.updateUserProfile(user)) {
//			 result.setSuccess(true);
//		     result.setMessage("Profile of User " + user.getLogin() +" was succesfully updated");
//		     result.setData(id);
//			} else {
//				 result.setSuccess(false);
//			     result.setMessage("Category wasn't deleted");
//			     result.setData(-1);				
//			}
//		} catch(Exception e) {
//			result.setSuccess(false);
//			result.setMessage(e.getMessage());
//			result.setData(-1);
//		}
		
		return result;
	}
}
