package com.sifox.dao;

import org.springframework.stereotype.Component;

import com.sifox.entity.UserProfile;

@Component("shameDeskDAO")
public class UserProfileDAO extends _DAO<UserProfile> {

	@Override
	public boolean isUnique(UserProfile entity) {
		return true;
	}
	
}
