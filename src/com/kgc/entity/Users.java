package com.kgc.entity;

public class Users 
{
	private int id;
	private String usersName;
	private String passWord;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Users(int id, String usersName, String passWord) {
		super();
		this.id = id;
		this.usersName = usersName;
		this.passWord = passWord;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
}
