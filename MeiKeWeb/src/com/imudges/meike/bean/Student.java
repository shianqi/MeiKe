package com.imudges.meike.bean;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private Integer usersId;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Integer usersId) {
		this.usersId = usersId;
	}

	// Property accessors

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

}