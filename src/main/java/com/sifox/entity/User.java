package com.sifox.entity;

import javax.persistence.*;

/**
 * @Author Zaytsev Roman V.
 * @date 18.05.2017
 */

@Entity
@Table(name = "USER", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
@org.hibernate.annotations.AccessType("field")

public class User extends _Entity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
	
	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	private String password;
		
	@Column(name = "ADMIN")
	private boolean admin;
		
	@OneToOne
    @JoinColumn(name = "ID")
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserProfile userProfile;
	
	@OneToOne
    @JoinColumn(name = "ID")
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ShameDesk shameDesk;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword()  {
		return password;
	}

	public void setPassword(String password)  {
		this.password = password;
	}

	public synchronized boolean isAdmin() {
		return admin;
	}

	public synchronized void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public ShameDesk getShameDesk() {
		return shameDesk;
	}

	public void setShameDesk(ShameDesk shameDesk) {
		this.shameDesk = shameDesk;
	}
	
}
