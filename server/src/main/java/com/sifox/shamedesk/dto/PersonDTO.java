package com.sifox.shamedesk.dto;

/**
 * 
 * @Author Zaytsev Roman V.
 * @date 22.05.2017
 */
public class PersonDTO extends AbstractDTO {
	
    String login;

    String password;

    String name;

    int score;

    String comment;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "PersonDTO [login=" + login + ", name=" + name + ", score=" + score + ", comment="
				+ comment + "]";
	}   
}
