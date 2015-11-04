package com.imudges.meike.bean;

/**
 * UserimageId entity. @author MyEclipse Persistence Tools
 */
public class UserimageId extends AbstractUserimageId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserimageId() {
		
	}
	public UserimageId(Integer usersId) {
		super(usersId);
	}
	/** minimal constructor */
	public UserimageId(Integer usersId,Integer imageId) {
		super(usersId,imageId);
	}

	/** full constructor */
	public UserimageId(String url, Integer usersId,Integer imageId) {
		super(url, usersId,imageId);
	}

}
