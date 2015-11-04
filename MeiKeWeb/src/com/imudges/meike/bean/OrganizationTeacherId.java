package com.imudges.meike.bean;

/**
 * OrganizationTeacherId entity. @author MyEclipse Persistence Tools
 */

public class OrganizationTeacherId implements java.io.Serializable {

	// Fields

	private Integer organizationId;
	private Integer teacherId;
	private Integer usersId;

	// Constructors

	/** default constructor */
	public OrganizationTeacherId() {
	}

	/** full constructor */
	public OrganizationTeacherId(Integer organizationId, Integer teacherId,
			Integer usersId) {
		this.organizationId = organizationId;
		this.teacherId = teacherId;
		this.usersId = usersId;
	}

	// Property accessors

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
		if (!(other instanceof OrganizationTeacherId))
			return false;
		OrganizationTeacherId castOther = (OrganizationTeacherId) other;

		return ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
				.getOrganizationId() != null
				&& castOther.getOrganizationId() != null && this
				.getOrganizationId().equals(castOther.getOrganizationId())))
				&& ((this.getTeacherId() == castOther.getTeacherId()) || (this
						.getTeacherId() != null
						&& castOther.getTeacherId() != null && this
						.getTeacherId().equals(castOther.getTeacherId())))
				&& ((this.getUsersId() == castOther.getUsersId()) || (this
						.getUsersId() != null && castOther.getUsersId() != null && this
						.getUsersId().equals(castOther.getUsersId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		result = 37 * result
				+ (getTeacherId() == null ? 0 : this.getTeacherId().hashCode());
		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		return result;
	}

}