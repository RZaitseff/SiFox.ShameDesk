package com.sifox.dao;

import javax.persistence.EntityManager;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sifox.entity.*;

@Component("userDAO")
public class UserDAO extends _DAO<User> {
	
	@Override
	public boolean isUnique(User entity) {
		return count("login", entity.getLogin()) == 0;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String path = "data.xml";
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(path);   
//		UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);

		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(path);   
		UserDAO userDAO = new UserDAO();
		UserProfileDAO profileDAO = new UserProfileDAO();
		ShameDeskDAO deskDAO = new ShameDeskDAO();
		EntityManager em = 
				((org.springframework.orm.jpa.JpaTransactionManager) 
						ctx.getBean("txManager")).getEntityManagerFactory().createEntityManager();
		userDAO.em = em; 
		deskDAO.em = em;
		profileDAO.em = em; 
		System.out.println("User count = "  + userDAO.count());
		System.out.println("Count of admin users = "  + userDAO.count("admin", "true"));
				
		System.out.println("---------- Create user ADMIN -----------------");		
		User userAdm = new User();
		userAdm.setLogin("admin");
		userAdm.setPassword("admin");
		userAdm.setAdmin(true);
		
		UserProfile profile = new UserProfile();
		profile.setName("Administrator of Shame Desk");
		userAdm.setUserProfile(profile);
		
		ShameDesk desk = new ShameDesk();
		desk.setComment("Administrator is out of Desk");
		desk.setScore(-1);		
		userAdm.setShameDesk(desk);

		em.getTransaction().begin();
		int userId = userDAO.create(userAdm);
		profile.setId(userId);
		profileDAO.create(profile);
		desk.setId(userId);
		deskDAO.create(desk);
		em.getTransaction().commit();
		
		System.out.println("--------- User List Score --------------");
		for(User user: userDAO.list()) {
			System.out.println("user Id: "  + user.getId()
						+ ", user admin right: "  + user.isAdmin()
						+ ", user login: " + user.getLogin()
						+ ", user password: "  + user.getPassword()
						+ ", user name: "  + user.getUserProfile().getName()
						+ ", user score: "  + user.getShameDesk().getScore());
		}
		
		System.out.println("----------------------------------------------");
	}
}
