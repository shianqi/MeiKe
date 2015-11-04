package com.imudges.meike.bean;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private String usersName;
	private String password;
	private Short isStudent;
	private String email;
	private String wechatId;
	private String weiboId;
	private Integer imageId;
	private String phoneNumber;
	private String name;
	private Integer emailStatus;
	private String sendTime;
	private String hashCode;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String password, Short isStudent) {
		this.password = password;
		this.isStudent = isStudent;
	}

	/** full constructor */
	public Users(String usersName, String password, Short isStudent,
			String email, String wechatId, String weiboId, Integer imageId,
			String phoneNumber, String name, Integer emailStatus,
			String sendTime, String hashCode) {
		this.usersName = usersName;
		this.password = password;
		this.isStudent = isStudent;
		this.email = email;
		this.wechatId = wechatId;
		this.weiboId = weiboId;
		this.imageId = imageId;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.emailStatus = emailStatus;
		this.sendTime = sendTime;
		this.hashCode = hashCode;
	}

	// Property accessors

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return this.usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getIsStudent() {
		return this.isStudent;
	}

	public void setIsStudent(Short isStudent) {
		this.isStudent = isStudent;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechatId() {
		return this.wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getWeiboId() {
		return this.weiboId;
	}

	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
	}

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmailStatus() {
		return this.emailStatus;
	}

	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getHashCode() {
		return this.hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

}