package com.imudges.meike.bean;

/**
 * OrganizationClassesTeacherId entity. @author MyEclipse Persistence Tools
 */

public class OrganizationClassesTeacherId implements java.io.Serializable {

	// Fields

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

	/** default constructor */
	public OrganizationClassesTeacherId() {
	}

	/** minimal constructor */
	public OrganizationClassesTeacherId(Integer classId,
			Integer organizationId, Integer teacherId, String className,
			String organizationName, String classType, String description,
			Integer usersId) {
		this.classId = classId;
		this.organizationId = organizationId;
		this.teacherId = teacherId;
		this.className = className;
		this.organizationName = organizationName;
		this.classType = classType;
		this.description = description;
		this.usersId = usersId;
	}

	/** full constructor */
	public OrganizationClassesTeacherId(Integer classId,
			Integer organizationId, Integer teacherId, String className,
			String organizationName, String classType, Integer imageId,
			String description, Integer usersId) {
		this.classId = classId;
		this.organizationId = organizationId;
		this.teacherId = teacherId;
		this.className = className;
		this.organizationName = organizationName;
		this.classType = classType;
		this.imageId = imageId;
		this.description = description;
		this.usersId = usersId;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getClassType() {
		return this.classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrganizationClassesTeacherId))
			return false;
		OrganizationClassesTeacherId castOther = (OrganizationClassesTeacherId) other;

		return ((this.getClassId() == castOther.getClassId()) || (this
				.getClassId() != null && castOther.getClassId() != null && this
				.getClassId().equals(castOther.getClassId())))
				&& ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
						.getOrganizationId() != null
						&& castOther.getOrganizationId() != null && this
						.getOrganizationId().equals(
								castOther.getOrganizationId())))
				&& ((this.getTeacherId() == castOther.getTeacherId()) || (this
						.getTeacherId() != null
						&& castOther.getTeacherId() != null && this
						.getTeacherId().equals(castOther.getTeacherId())))
				&& ((this.getClassName() == castOther.getClassName()) || (this
						.getClassName() != null
						&& castOther.getClassName() != null && this
						.getClassName().equals(castOther.getClassName())))
				&& ((this.getOrganizationName() == castOther
						.getOrganizationName()) || (this.getOrganizationName() != null
						&& castOther.getOrganizationName() != null && this
						.getOrganizationName().equals(
								castOther.getOrganizationName())))
				&& ((this.getClassType() == castOther.getClassType()) || (this
						.getClassType() != null
						&& castOther.getClassType() != null && this
						.getClassType().equals(castOther.getClassType())))
				&& ((this.getImageId() == castOther.getImageId()) || (this
						.getImageId() != null && castOther.getImageId() != null && this
						.getImageId().equals(castOther.getImageId())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& ((this.getUsersId() == castOther.getUsersId()) || (this
						.getUsersId() != null && castOther.getUsersId() != null && this
						.getUsersId().equals(castOther.getUsersId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		result = 37 * result
				+ (getTeacherId() == null ? 0 : this.getTeacherId().hashCode());
		result = 37 * result
				+ (getClassName() == null ? 0 : this.getClassName().hashCode());
		result = 37
				* result
				+ (getOrganizationName() == null ? 0 : this
						.getOrganizationName().hashCode());
		result = 37 * result
				+ (getClassType() == null ? 0 : this.getClassType().hashCode());
		result = 37 * result
				+ (getImageId() == null ? 0 : this.getImageId().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		return result;
	}

}