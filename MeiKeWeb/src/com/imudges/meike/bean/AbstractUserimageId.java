package com.imudges.meike.bean;

/**
 * AbstractUserimageId entity provides the base persistence definition of the
 * UserimageId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserimageId implements java.io.Serializable {

	// Fields

	private String url;
	private Integer usersId;
	private Integer imageId;

	// Constructors

	/** default constructor */
	public AbstractUserimageId() {
		
	}
	
	public AbstractUserimageId(Integer usersId) {
		this.usersId = usersId;
	}
	/** minimal constructor */
	public AbstractUserimageId(Integer usersId, Integer imageId) {
		this.usersId = usersId;
		this.imageId = imageId;
	}

	/** full constructor */
	public AbstractUserimageId(String url, Integer usersId, Integer imageId) {
		this.url = url;
		this.usersId = usersId;
		this.imageId = imageId;
	}

	// Property accessors

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractUserimageId))
			return false;
		AbstractUserimageId castOther = (AbstractUserimageId) other;

		return ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
				&& castOther.getUrl() != null && this.getUrl().equals(
				castOther.getUrl())))
				&& ((this.getUsersId() == castOther.getUsersId()) || (this
						.getUsersId() != null && castOther.getUsersId() != null && this
						.getUsersId().equals(castOther.getUsersId())))
				&& ((this.getImageId() == castOther.getImageId()) || (this
						.getImageId() != null && castOther.getImageId() != null && this
						.getImageId().equals(castOther.getImageId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		result = 37 * result
				+ (getImageId() == null ? 0 : this.getImageId().hashCode());
		return result;
	}

}