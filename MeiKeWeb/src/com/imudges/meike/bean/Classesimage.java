package com.imudges.meike.bean;

/**
 * Classesimage entity. @author MyEclipse Persistence Tools
 */

public class Classesimage implements java.io.Serializable {

	// Fields

	private ClassesimageId id = new ClassesimageId();
	private Integer imageId;
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getClassId() {
		return getId().getClassId();
	}

	public void setClassId(Integer classId) {
		this.id.setClassId(classId);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private Integer classId;
	private String url;

	// Constructors

	/** default constructor */
	public Classesimage() {
	}

	/** full constructor */
	public Classesimage(ClassesimageId id) {
		this.id = id;
	}

	// Property accessors

	public ClassesimageId getId() {
		return this.id;
	}

	public void setId(ClassesimageId id) {
		this.id = id;
	}

}