package com.imudges.meike.bean;

/**
 * TeacherUserClass entity. @author MyEclipse Persistence Tools
 */

public class TeacherUserClass implements java.io.Serializable {

	// Fields

	private TeacherUserClassId id;

	private Integer usersId;
	private String usersName;
	private Integer teacherId;
	private Integer classId;
	private String className;

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

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getClassId() {
		return getId().getClassId();
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	/** default constructor */
	public TeacherUserClass() {
	}

	/** full constructor */
	public TeacherUserClass(TeacherUserClassId id) {
		this.id = id;
	}

	// Property accessors

	public TeacherUserClassId getId() {
		return this.id;
	}

	public void setId(TeacherUserClassId id) {
		this.id = id;
	}

}