package com.sifox.shamedesk.model;

import javax.persistence.Entity;

@Entity
public class Person extends AbstractEntity {

	private static final long serialVersionUID = -6321180910534044216L;

    String login;

    String name;

    int score;

    String comment;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
