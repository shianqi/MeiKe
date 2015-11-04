package com.imudges.meike.bean;

/**
 * OrganizationUsers entity. @author MyEclipse Persistence Tools
 */

public class OrganizationUsers implements java.io.Serializable {

	// Fields

	private OrganizationUsersId id;

	private Integer organizationId;
	private Integer usersId;
	private String phoneNumber;
	private String organizationName;
	private Integer image;
	private String description;
	private Integer describeImageId1;
	private Integer describeImageId3;
	private Integer describeImageId2;
	private Double latitude;
	private Double longitude;
	private String city;
	private String email;
	private Short isStudent;
	
	

	// Constructors

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getImage() {
		return image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDescribeImageId1() {
		return describeImageId1;
	}

	public void setDescribeImageId1(Integer describeImageId1) {
		this.describeImageId1 = describeImageId1;
	}

	public Integer getDescribeImageId3() {
		return describeImageId3;
	}

	public void setDescribeImageId3(Integer describeImageId3) {
		this.describeImageId3 = describeImageId3;
	}

	public Integer getDescribeImageId2() {
		return describeImageId2;
	}

	public void setDescribeImageId2(Integer describeImageId2) {
		this.describeImageId2 = describeImageId2;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(Short isStudent) {
		this.isStudent = isStudent;
	}

	/** default constructor */
	public OrganizationUsers() {
	}

	/** full constructor */
	public OrganizationUsers(OrganizationUsersId id) {
		this.id = id;
	}

	// Property accessors

	public OrganizationUsersId getId() {
		return this.id;
	}

	public void setId(OrganizationUsersId id) {
		this.id = id;
	}

}