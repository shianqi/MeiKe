package com.imudges.meike.bean;

/**
 * Userimage entity. @author MyEclipse Persistence Tools
 */
public class Userimage extends AbstractUserimage implements
		java.io.Serializable {

	// Constructors
	private String url;
	private Integer usersId;
	private Integer imageId;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUsersId() {
		return getId().getUsersId();
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	/** default constructor */
	public Userimage() {
	}

	/** full constructor */
	public Userimage(UserimageId id) {
		super(id);
	}

}
