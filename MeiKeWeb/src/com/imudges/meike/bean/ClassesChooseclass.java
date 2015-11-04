package com.imudges.meike.bean;

/**
 * ClassesChooseclass entity. @author MyEclipse Persistence Tools
 */

public class ClassesChooseclass implements java.io.Serializable {

	// Fields

	private ClassesChooseclassId id;

	// Constructors

	/** default constructor */
	public ClassesChooseclass() {
	}

	/** full constructor */
	public ClassesChooseclass(ClassesChooseclassId id) {
		this.id = id;
	}

	// Property accessors

	public ClassesChooseclassId getId() {
		return this.id;
	}

	public void setId(ClassesChooseclassId id) {
		this.id = id;
	}

}