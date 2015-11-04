package com.imudges.meike.bean;

/**
 * OrganizationUsersId entity. @author MyEclipse Persistence Tools
 */

public class OrganizationUsersId implements java.io.Serializable {

	// Fields

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

	/** default constructor */
	public OrganizationUsersId() {
	}

	/** minimal constructor */
	public OrganizationUsersId(Integer organizationId, Integer usersId,
			String organizationName, Integer image, String description,
			Short isStudent) {
		this.organizationId = organizationId;
		this.usersId = usersId;
		this.organizationName = organizationName;
		this.image = image;
		this.description = description;
		this.isStudent = isStudent;
	}

	/** full constructor */
	public OrganizationUsersId(Integer organizationId, Integer usersId,
			String phoneNumber, String organizationName, Integer image,
			String description, Integer describeImageId1,
			Integer describeImageId3, Integer describeImageId2,
			Double latitude, Double longitude, String city, String email,
			Short isStudent) {
		this.organizationId = organizationId;
		this.usersId = usersId;
		this.phoneNumber = phoneNumber;
		this.organizationName = organizationName;
		this.image = image;
		this.description = description;
		this.describeImageId1 = describeImageId1;
		this.describeImageId3 = describeImageId3;
		this.describeImageId2 = describeImageId2;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.email = email;
		this.isStudent = isStudent;
	}

	// Property accessors

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Integer getDescribeImageId3() {
		return this.describeImageId3;
	}

	public void setDescribeImageId3(Integer describeImageId3) {
		this.describeImageId3 = describeImageId3;
	}

	public Integer getDescribeImageId2() {
		return this.describeImageId2;
	}

	public void setDescribeImageId2(Integer describeImageId2) {
		this.describeImageId2 = describeImageId2;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getIsStudent() {
		return this.isStudent;
	}

	public void setIsStudent(Short isStudent) {
		this.isStudent = isStudent;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrganizationUsersId))
			return false;
		OrganizationUsersId castOther = (OrganizationUsersId) other;

		return ((this.getOrganizationId() == castOther.getOrganizationId()) || (this
				.getOrganizationId() != null
				&& castOther.getOrganizationId() != null && this
				.getOrganizationId().equals(castOther.getOrganizationId())))
				&& ((this.getUsersId() == castOther.getUsersId()) || (this
						.getUsersId() != null && castOther.getUsersId() != null && this
						.getUsersId().equals(castOther.getUsersId())))
				&& ((this.getPhoneNumber() == castOther.getPhoneNumber()) || (this
						.getPhoneNumber() != null
						&& castOther.getPhoneNumber() != null && this
						.getPhoneNumber().equals(castOther.getPhoneNumber())))
				&& ((this.getOrganizationName() == castOther
						.getOrganizationName()) || (this.getOrganizationName() != null
						&& castOther.getOrganizationName() != null && this
						.getOrganizationName().equals(
								castOther.getOrganizationName())))
				&& ((this.getImage() == castOther.getImage()) || (this
						.getImage() != null && castOther.getImage() != null && this
						.getImage().equals(castOther.getImage())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& ((this.getDescribeImageId1() == castOther
						.getDescribeImageId1()) || (this.getDescribeImageId1() != null
						&& castOther.getDescribeImageId1() != null && this
						.getDescribeImageId1().equals(
								castOther.getDescribeImageId1())))
				&& ((this.getDescribeImageId3() == castOther
						.getDescribeImageId3()) || (this.getDescribeImageId3() != null
						&& castOther.getDescribeImageId3() != null && this
						.getDescribeImageId3().equals(
								castOther.getDescribeImageId3())))
				&& ((this.getDescribeImageId2() == castOther
						.getDescribeImageId2()) || (this.getDescribeImageId2() != null
						&& castOther.getDescribeImageId2() != null && this
						.getDescribeImageId2().equals(
								castOther.getDescribeImageId2())))
				&& ((this.getLatitude() == castOther.getLatitude()) || (this
						.getLatitude() != null
						&& castOther.getLatitude() != null && this
						.getLatitude().equals(castOther.getLatitude())))
				&& ((this.getLongitude() == castOther.getLongitude()) || (this
						.getLongitude() != null
						&& castOther.getLongitude() != null && this
						.getLongitude().equals(castOther.getLongitude())))
				&& ((this.getCity() == castOther.getCity()) || (this.getCity() != null
						&& castOther.getCity() != null && this.getCity()
						.equals(castOther.getCity())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getIsStudent() == castOther.getIsStudent()) || (this
						.getIsStudent() != null
						&& castOther.getIsStudent() != null && this
						.getIsStudent().equals(castOther.getIsStudent())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getOrganizationId() == null ? 0 : this.getOrganizationId()
						.hashCode());
		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		result = 37
				* result
				+ (getPhoneNumber() == null ? 0 : this.getPhoneNumber()
						.hashCode());
		result = 37
				* result
				+ (getOrganizationName() == null ? 0 : this
						.getOrganizationName().hashCode());
		result = 37 * result
				+ (getImage() == null ? 0 : this.getImage().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		result = 37
				* result
				+ (getDescribeImageId1() == null ? 0 : this
						.getDescribeImageId1().hashCode());
		result = 37
				* result
				+ (getDescribeImageId3() == null ? 0 : this
						.getDescribeImageId3().hashCode());
		result = 37
				* result
				+ (getDescribeImageId2() == null ? 0 : this
						.getDescribeImageId2().hashCode());
		result = 37 * result
				+ (getLatitude() == null ? 0 : this.getLatitude().hashCode());
		result = 37 * result
				+ (getLongitude() == null ? 0 : this.getLongitude().hashCode());
		result = 37 * result
				+ (getCity() == null ? 0 : this.getCity().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getIsStudent() == null ? 0 : this.getIsStudent().hashCode());
		return result;
	}

}