package com.imudges.meike.bean;

/**
 * Slidebox entity. @author MyEclipse Persistence Tools
 */

public class Slidebox implements java.io.Serializable {

	// Fields

	private Integer slideboxId;
	private String url1;
	private String url2;
	private String url3;

	// Constructors

	/** default constructor */
	public Slidebox() {
	}

	/** full constructor */
	public Slidebox(String url1, String url2, String url3) {
		this.url1 = url1;
		this.url2 = url2;
		this.url3 = url3;
	}

	// Property accessors

	public Integer getSlideboxId() {
		return this.slideboxId;
	}

	public void setSlideboxId(Integer slideboxId) {
		this.slideboxId = slideboxId;
	}

	public String getUrl1() {
		return this.url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return this.url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return this.url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

}