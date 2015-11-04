package com.imudges.meike.bean;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */

public class Organization implements java.io.Serializable {

	// Fields

	private Integer organizationId;
	private String organizationName;
	private Integer image;
	private String description;
	private Integer describeImageId1;
	private Integer describeImageId2;
	private Integer describeImageId3;
	private Double latitude;
	private Double longitude;
	private String city;
	private Integer usersId;
	private String address;
	private String tel;

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** minimal constructor */
	public Organization(String organizationName, Integer image,
			String description) {
		this.organizationName = organizationName;
		this.image = image;
		this.description = description;
	}

	/** full constructor */
	public Organization(String organizationName, Integer image,
			String description, Integer describeImageId1,
			Integer describeImageId2, Integer describeImageId3,
			Double latitude, Double longitude, String city, Integer usersId,
			String address, String tel) {
		this.organizationName = organizationName;
		this.image = image;
		this.description = description;
		this.describeImageId1 = describeImageId1;
		this.describeImageId2 = describeImageId2;
		this.describeImageId3 = describeImageId3;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.usersId = usersId;
		this.address = address;
		this.tel = tel;
	}

	// Property accessors

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getImage() {
		return this.image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDescribeImageId1() {
		return this.describeImageId1;
	}

	public void setDescribeImageId1(Integer describeImageId1) {
		this.describeImageId1 = describeImageId1;
	}

	public Integer getDescribeImageId2() {
		return this.describeImageId2;
	}

	public void setDescribeImageId2(Integer describeImageId2) {
		this.describeImageId2 = describeImageId2;
	}

	public Integer getDescribeImageId3() {
		return this.describeImageId3;
	}

	public void setDescribeImageId3(Integer describeImageId3) {
		this.describeImageId3 = describeImageId3;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}