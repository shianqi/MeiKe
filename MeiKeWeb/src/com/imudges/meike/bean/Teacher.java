package com.imudges.meike.bean;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private Integer usersId;
	private Short isTutor;
	private Integer ofOrganizationId;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(Integer usersId, Short isTutor, Integer ofOrganizationId) {
		this.usersId = usersId;
		this.isTutor = isTutor;
		this.ofOrganizationId = ofOrganizationId;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Short getIsTutor() {
		return this.isTutor;
	}

	public void setIsTutor(Short isTutor) {
		this.isTutor = isTutor;
	}

	public Integer getOfOrganizationId() {
		return this.ofOrganizationId;
	}

	public void setOfOrganizationId(Integer ofOrganizationId) {
		this.ofOrganizationId = ofOrganizationId;
	}

}