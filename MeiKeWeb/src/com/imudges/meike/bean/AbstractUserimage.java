package com.imudges.meike.bean;

/**
 * AbstractUserimage entity provides the base persistence definition of the
 * Userimage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserimage implements java.io.Serializable {

	// Fields

	private UserimageId id;

	// Constructors

	/** default constructor */
	public AbstractUserimage() {
	}

	/** full constructor */
	public AbstractUserimage(UserimageId id) {
		this.id = id;
	}

	// Property accessors

	public UserimageId getId() {
		return this.id;
	}

	public void setId(UserimageId id) {
		this.id = id;
	}

}