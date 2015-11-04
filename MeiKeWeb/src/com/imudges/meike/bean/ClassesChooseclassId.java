package com.imudges.meike.bean;

/**
 * ClassesChooseclassId entity. @author MyEclipse Persistence Tools
 */

public class ClassesChooseclassId implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private Integer classId;

	// Constructors

	/** default constructor */
	public ClassesChooseclassId() {
	}

	/** full constructor */
	public ClassesChooseclassId(Integer studentId, Integer classId) {
		this.studentId = studentId;
		this.classId = classId;
	}

	// Property accessors

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClassesChooseclassId))
			return false;
		ClassesChooseclassId castOther = (ClassesChooseclassId) other;

		return ((this.getStudentId() == castOther.getStudentId()) || (this
				.getStudentId() != null && castOther.getStudentId() != null && this
				.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null && castOther.getClassId() != null && this
						.getClassId().equals(castOther.getClassId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		return result;
	}

}