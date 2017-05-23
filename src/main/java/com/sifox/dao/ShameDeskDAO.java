package com.sifox.dao;

import org.springframework.stereotype.Component;

import com.sifox.entity.ShameDesk;

@Component("shameDeskDAO")
public class ShameDeskDAO extends _DAO<ShameDesk> {

	@Override
	public boolean isUnique(ShameDesk entity) {
		return true;
	}
	
}
