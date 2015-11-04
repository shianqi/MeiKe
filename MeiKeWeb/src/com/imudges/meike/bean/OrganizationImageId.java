package com.imudges.meike.bean;

/**
 * OrganizationImageId entity. @author MyEclipse Persistence Tools
 */

public class OrganizationImageId implements java.io.Serializable {

	// Fields

	private String url;
	private Integer imageId;
	private Integer organizationId;

	// Constructors

	/** default constructor */
	public OrganizationImageId() {
	}

	/** minimal constructor */
	public OrganizationImageId(Integer imageId, Integer organizationId) {
		this.imageId = imageId;
		this.organizationId = organizationId;
	}

	/** full constructor */
	public OrganizationImageId(String url, Integer imageId,
			Integer organizationId) {
		this.url = url;
		this.imageId = imageId;
		this.organizationId = organizationId;
	}

	// Property accessors

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrganizationImageId))
			return false;
		OrganizationImageId castOther = (OrganizationImageId) other;

		return ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
				&& castOther.getUrl() != null && this.getUrl().equals(
				castOther.getUrl())))
				&& ((this.getImageId() == castOther.getImageId()) || (this
						.getImageId() != null && castOther.getImageId() != null && this
						.getImageId().equals(castOther.getImageId())))
				&& ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
						.getOrganizationId() != null
						&& castOther.getOrganizationId() != null && this
						.getOrganizationId().equals(
								castOther.getOrganizationId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		result = 37 * result
				+ (getImageId() == null ? 0 : this.getImageId().hashCode());
		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		return result;
	}

}