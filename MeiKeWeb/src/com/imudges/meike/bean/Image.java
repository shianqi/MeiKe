package com.imudges.meike.bean;

/**
 * Image entity. @author MyEclipse Persistence Tools
 */

public class Image implements java.io.Serializable {

	// Fields

	private Integer imageId;
	private String url;

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** full constructor */
	public Image(String url) {
		this.url = url;
	}

	// Property accessors

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}