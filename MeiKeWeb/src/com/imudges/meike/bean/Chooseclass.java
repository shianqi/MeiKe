package com.imudges.meike.bean;

/**
 * Chooseclass entity. @author MyEclipse Persistence Tools
 */

public class Chooseclass implements java.io.Serializable {

	// Fields

	private Integer chooseClassId;
	private Integer classId;
	private Integer studentId;

	// Constructors

	/** default constructor */
	public Chooseclass() {
	}

	/** full constructor */
	public Chooseclass(Integer classId, Integer studentId) {
		this.classId = classId;
		this.studentId = studentId;
	}

	// Property accessors

	public Integer getChooseClassId() {
		return this.chooseClassId;
	}

	public void setChooseClassId(Integer chooseClassId) {
		this.chooseClassId = chooseClassId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}