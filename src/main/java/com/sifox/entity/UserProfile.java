package com.sifox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @Author Zaytsev Roman V.
 * @date 18.05.2017
 */

@Entity
@Table(name = "USERPROFILE", uniqueConstraints = {@UniqueConstraint(columnNames = "UserId")})
@org.hibernate.annotations.AccessType("field")
public class UserProfile extends _Entity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "UserId", unique = true, nullable = false)
	private int id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CELL")
	private String cell;
	
//	private User user;
//	
//	@OneToOne
//    @JoinColumn(name = "UserID")
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    public User getUser() {
//        return user;
//    }
//    
//	public void setUser(User user) {
//		this.user = user;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

}
