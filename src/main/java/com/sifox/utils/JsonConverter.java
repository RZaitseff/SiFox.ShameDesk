package com.sifox.utils;

import java.util.List;

import org.json.*;

import com.sifox.entity.User;

public class JsonConverter {
	
	public static String userListToJSON(List<User> userList) {
		JSONArray jsonArr = new JSONArray();
		for(User user : userList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("login",   user.getLogin());
			jsonObject.put("name",    user.getUserProfile().getName());
			jsonObject.put("score",   user.getShameDesk().getScore());
			jsonObject.put("comment", user.getShameDesk().getComment());
			jsonArr.put(jsonObject);
		}
		return jsonArr.toString();
	}	
}
