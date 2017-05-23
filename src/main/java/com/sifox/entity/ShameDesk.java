package com.sifox.entity;

import javax.persistence.*;

/**
 * 
 * @Author Zaytsev Roman V.
 * @date 18.05.2017
 */
@Entity
@Table(name = "ShameDesk", uniqueConstraints = {@UniqueConstraint(columnNames = "UserId")})
@org.hibernate.annotations.AccessType("field")
public class ShameDesk extends _Entity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "UserId", unique = true, nullable = false)
	private int id;
	
	@Column(name = "score")
	private int score;

	@Column(name = "comment")
	private String comment;

//	private User user;
//	
//	@OneToOne
//    @JoinColumn(name = "userId")
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

	public int getScore() {
		return score;
	}

	public  void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
