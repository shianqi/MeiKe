package com.imudges.meike.bean;

/**
 * TeacherUserClassId entity. @author MyEclipse Persistence Tools
 */

public class TeacherUserClassId implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private String usersName;
	private Integer teacherId;
	private Integer classId;
	private String className;

	// Constructors

	/** default constructor */
	public TeacherUserClassId() {
	}

	/** minimal constructor */
	public TeacherUserClassId(Integer usersId, Integer teacherId,
			Integer classId, String className) {
		this.usersId = usersId;
		this.teacherId = teacherId;
		this.classId = classId;
		this.className = className;
	}

	/** full constructor */
	public TeacherUserClassId(Integer usersId, String usersName,
			Integer teacherId, Integer classId, String className) {
		this.usersId = usersId;
		this.usersName = usersName;
		this.teacherId = teacherId;
		this.classId = classId;
		this.className = className;
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

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeacherUserClassId))
			return false;
		TeacherUserClassId castOther = (TeacherUserClassId) other;

		return ((this.getUsersId() == castOther.getUsersId()) || (this
				.getUsersId() != null && castOther.getUsersId() != null && this
				.getUsersId().equals(castOther.getUsersId())))
				&& ((this.getUsersName() == castOther.getUsersName()) || (this
						.getUsersName() != null
						&& castOther.getUsersName() != null && this
						.getUsersName().equals(castOther.getUsersName())))
				&& ((this.getTeacherId() == castOther.getTeacherId()) || (this
						.getTeacherId() != null
						&& castOther.getTeacherId() != null && this
						.getTeacherId().equals(castOther.getTeacherId())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null && castOther.getClassId() != null && this
						.getClassId().equals(castOther.getClassId())))
				&& ((this.getClassName() == castOther.getClassName()) || (this
						.getClassName() != null
						&& castOther.getClassName() != null && this
						.getClassName().equals(castOther.getClassName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		result = 37 * result
				+ (getUsersName() == null ? 0 : this.getUsersName().hashCode());
		result = 37 * result
				+ (getTeacherId() == null ? 0 : this.getTeacherId().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37 * result
				+ (getClassName() == null ? 0 : this.getClassName().hashCode());
		return result;
	}

}