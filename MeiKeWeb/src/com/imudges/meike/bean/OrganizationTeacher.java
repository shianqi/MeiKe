package com.imudges.meike.bean;

/**
 * OrganizationTeacher entity. @author MyEclipse Persistence Tools
 */

public class OrganizationTeacher implements java.io.Serializable {

	// Fields

	private OrganizationTeacherId id;
	private Integer organizationId;
	private Integer teacherId;
	private Integer usersId;

	// Constructors

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getTeacherId() {
		return getId().getTeacherId();
	}

	public void setTeacherId(Integer teacherId) {
		getId().setTeacherId(teacherId);
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	/** default constructor */
	public OrganizationTeacher() {
	}

	/** full constructor */
	public OrganizationTeacher(OrganizationTeacherId id) {
		this.id = id;
	}

	// Property accessors

	public OrganizationTeacherId getId() {
		return this.id;
	}

	public void setId(OrganizationTeacherId id) {
		this.id = id;
	}

}