package com.sifox.service;

/** 
 * @updated 29.09.2015 by @author Zaytsev Rooman V.
 */


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifox.dao.ShameDeskDAO;

@Service
public class ShameDeskService
{

	@Autowired
	private ShameDeskDAO shameDeskDAO;
	
	public Integer count() {
		return shameDeskDAO.count();
	}
		
	public Integer count(String name) {
		return shameDeskDAO.count(name);
	}
		
//	public List<Currency> list() {
//		return shameDeskDAO.list();
//	}
//		
//	public List<String> nameList() {
//		List<Currency> list = shameDeskDAO.list();
//		if(list == null) return null;
//		List<String> listNames = new LinkedList<String>();
//		for(Currency c: list) 
//			listNames.add(c.getAbbreviation());
//		return listNames;
//	}
//		
//	public Currency read(int code) {
//        return  shameDeskDAO.read(code);
//	}
//
//	public Currency read(String name) {
//        return  shameDeskDAO.read(name);
//	}
//
//	public Integer create(Currency currency) {
//        return  shameDeskDAO.create(currency);
//	}
//
//	public Boolean rename(String oldName, String newName) {
//        return  shameDeskDAO.rename(oldName, newName);
//	}
//
//	public Boolean delete(String name) {
//        return  shameDeskDAO.delete(name);
//	}
//
//	public Boolean delete(int code) {
//        return  shameDeskDAO.delete(code);
//	}

}
