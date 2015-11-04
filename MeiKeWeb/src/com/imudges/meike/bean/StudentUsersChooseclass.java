package com.imudges.meike.bean;

/**
 * StudentUsersChooseclass entity. @author MyEclipse Persistence Tools
 */

public class StudentUsersChooseclass implements java.io.Serializable {

	// Fields

	private StudentUsersChooseclassId id;
	private Integer usersId;
	private String usersName;
	private String password;
	private Short isStudent;
	private String email;
	private String wechatId;
	private String weiboId;
	private String imageId;
	private String phoneNumber;
	private String name;
	private Integer studentId;
	private Integer classId;
	private Integer chooseClassId;

	// Constructors

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

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getChooseClassId() {
		return getId().getChooseClassId();
	}

	public void setChooseClassId(Integer chooseClassId) {
		this.chooseClassId = chooseClassId;
	}

	/** default constructor */
	public StudentUsersChooseclass() {
	}

	/** full constructor */
	public StudentUsersChooseclass(StudentUsersChooseclassId id) {
		this.id = id;
	}

	// Property accessors

	public StudentUsersChooseclassId getId() {
		return this.id;
	}

	public void setId(StudentUsersChooseclassId id) {
		this.id = id;
	}

}