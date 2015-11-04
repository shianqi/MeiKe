package com.imudges.meike.bean;

/**
 * OrganizationImage entity. @author MyEclipse Persistence Tools
 */

public class OrganizationImage implements java.io.Serializable {

	// Fields

	private OrganizationImageId id;
	private String url;
	private Integer imageId;
	private Integer organizationId;

	// Constructors

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getImageId() {
		return getId().getImageId();
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/** default constructor */
	public OrganizationImage() {
	}

	/** full constructor */
	public OrganizationImage(OrganizationImageId id) {
		this.id = id;
	}

	// Property accessors

	public OrganizationImageId getId() {
		return this.id;
	}

	public void setId(OrganizationImageId id) {
		this.id = id;
	}

}