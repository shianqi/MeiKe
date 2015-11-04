package com.imudges.meike.model;

import com.imudges.meike.bean.Users;

public class LoginResult {
	private Integer usersId;
	private String usersName;
	private String password;
	private Short isStudent;
	private String email;
	private String wechatId;
	private String weiboId;
	private int imageId;
	private String phoneNumber;
	private String name;
	private int LoginStatus;
	private String imagePath;
	
	
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public LoginResult(Users users){
		this.usersId=users.getUsersId();
		this.usersName=users.getUsersName();
		this.password=users.getPassword();
		this.isStudent=users.getIsStudent();
		this.email=users.getEmail();
		this.wechatId=users.getWechatId();
		this.imageId=users.getImageId();
		this.phoneNumber=users.getPhoneNumber();
		this.name=users.getName();
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Short getIsStudent() {
		return isStudent;
	}
	public void setIsStudent(Short isStudent) {
		this.isStudent = isStudent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getWeiboId() {
		return weiboId;
	}
	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLoginStatus() {
		return LoginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		LoginStatus = loginStatus;
	}
}
