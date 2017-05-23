package com.sifox.service;

import java.io.File;
import java.util.Date;

import com.sifox.dao.UserDAO;
import com.sifox.utils.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StartupActionsService implements ApplicationListener<ContextRefreshedEvent>
{
	@Autowired
	private UserDAO userDAO;
	
	final static Logger logger = new Logger(StartupActionsService.class);
	
	private final static String USER_LIST_FILE = "UserList.txt"; 
	private final static String USER_LIST_CHANGE_DATA_FILE = "UserListChangeData.txt"; 
	
	private boolean wasExecuted = false;
	
	protected ClassLoader classLoader  = getClass().getClassLoader();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		long lastChanged, changed;
		
		File change = new File(classLoader.getResource(USER_LIST_CHANGE_DATA_FILE).getFile());
		change.exists();
		
		
		if (!this.wasExecuted)
		{
//			Date userListData = this.getUserListVersion();
//			logger.info("Change data of the user list is " + userListData.toLocaleString());
			File list = new File(classLoader.getResource(USER_LIST_FILE).getFile());
			logger.info(USER_LIST_FILE + "is directory: " + list.isDirectory());
			this.wasExecuted = true;
		}
	}
	
	private Long getUserListVersion() {
		File list = new File(classLoader.getResource(USER_LIST_FILE).getFile());
		logger.info(USER_LIST_FILE + " changed : " + list.lastModified());		
		return list.lastModified();	
	}
	
}
