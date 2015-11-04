package com.imudges.meike.bean;

/**
 * OrganizationClassesTeacher entity. @author MyEclipse Persistence Tools
 */

public class OrganizationClassesTeacher implements java.io.Serializable {

	// Fields

	private OrganizationClassesTeacherId id;
	private Integer classId;
	private Integer organizationId;
	private Integer teacherId;
	private String className;
	private String organizationName;
	private String classType;
	private Integer imageId;
	private String description;
	private Integer usersId;

	// Constructors

	public Integer getClassId() {
		return getId().getClassId();
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	/** default constructor */
	public OrganizationClassesTeacher() {
	}

	/** full constructor */
	public OrganizationClassesTeacher(OrganizationClassesTeacherId id) {
		this.id = id;
	}

	// Property accessors

	public OrganizationClassesTeacherId getId() {
		return this.id;
	}

	public void setId(OrganizationClassesTeacherId id) {
		this.id = id;
	}

}