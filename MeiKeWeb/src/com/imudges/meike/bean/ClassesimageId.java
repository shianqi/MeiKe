package com.imudges.meike.bean;

/**
 * ClassesimageId entity. @author MyEclipse Persistence Tools
 */

public class ClassesimageId implements java.io.Serializable {

	// Fields

	private Integer imageId;
	private Integer classId;
	private String url;

	// Constructors

	/** default constructor */
	public ClassesimageId() {
	}

	/** minimal constructor */
	public ClassesimageId(Integer classId) {
		this.classId = classId;
	}

	/** full constructor */
	public ClassesimageId(Integer imageId, Integer classId, String url) {
		this.imageId = imageId;
		this.classId = classId;
		this.url = url;
	}

	// Property accessors

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClassesimageId))
			return false;
		ClassesimageId castOther = (ClassesimageId) other;

		return ((this.getImageId() == castOther.getImageId()) || (this
				.getImageId() != null && castOther.getImageId() != null && this
				.getImageId().equals(castOther.getImageId())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null && castOther.getClassId() != null && this
						.getClassId().equals(castOther.getClassId())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getImageId() == null ? 0 : this.getImageId().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		return result;
	}

}