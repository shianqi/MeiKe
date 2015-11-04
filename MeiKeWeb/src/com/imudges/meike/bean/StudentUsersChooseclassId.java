package com.imudges.meike.bean;

/**
 * StudentUsersChooseclassId entity. @author MyEclipse Persistence Tools
 */

public class StudentUsersChooseclassId implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private String usersName;
	private String password;
	private Short isStudent;
	private String email;
	private String wechatId;
	private String weiboId;
	private String imageId;
	private String phoneNumber;
	private String name;
	private Integer studentId;
	private Integer classId;
	private Integer chooseClassId;

	// Constructors

	/** default constructor */
	public StudentUsersChooseclassId() {
	}

	/** minimal constructor */
	public StudentUsersChooseclassId(Integer usersId, String password,
			Short isStudent, Integer studentId, Integer classId,
			Integer chooseClassId) {
		this.usersId = usersId;
		this.password = password;
		this.isStudent = isStudent;
		this.studentId = studentId;
		this.classId = classId;
		this.chooseClassId = chooseClassId;
	}

	/** full constructor */
	public StudentUsersChooseclassId(Integer usersId, String usersName,
			String password, Short isStudent, String email, String wechatId,
			String weiboId, String imageId, String phoneNumber, String name,
			Integer studentId, Integer classId, Integer chooseClassId) {
		this.usersId = usersId;
		this.usersName = usersName;
		this.password = password;
		this.isStudent = isStudent;
		this.email = email;
		this.wechatId = wechatId;
		this.weiboId = weiboId;
		this.imageId = imageId;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.studentId = studentId;
		this.classId = classId;
		this.chooseClassId = chooseClassId;
	}

	// Property accessors

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return this.usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getIsStudent() {
		return this.isStudent;
	}

	public void setIsStudent(Short isStudent) {
		this.isStudent = isStudent;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechatId() {
		return this.wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getWeiboId() {
		return this.weiboId;
	}

	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
	}

	public String getImageId() {
		return this.imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getChooseClassId() {
		return this.chooseClassId;
	}

	public void setChooseClassId(Integer chooseClassId) {
		this.chooseClassId = chooseClassId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentUsersChooseclassId))
			return false;
		StudentUsersChooseclassId castOther = (StudentUsersChooseclassId) other;

		return ((this.getUsersId() == castOther.getUsersId()) || (this
				.getUsersId() != null && castOther.getUsersId() != null && this
				.getUsersId().equals(castOther.getUsersId())))
				&& ((this.getUsersName() == castOther.getUsersName()) || (this
						.getUsersName() != null
						&& castOther.getUsersName() != null && this
						.getUsersName().equals(castOther.getUsersName())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getIsStudent() == castOther.getIsStudent()) || (this
						.getIsStudent() != null
						&& castOther.getIsStudent() != null && this
						.getIsStudent().equals(castOther.getIsStudent())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getWechatId() == castOther.getWechatId()) || (this
						.getWechatId() != null
						&& castOther.getWechatId() != null && this
						.getWechatId().equals(castOther.getWechatId())))
				&& ((this.getWeiboId() == castOther.getWeiboId()) || (this
						.getWeiboId() != null && castOther.getWeiboId() != null && this
						.getWeiboId().equals(castOther.getWeiboId())))
				&& ((this.getImageId() == castOther.getImageId()) || (this
						.getImageId() != null && castOther.getImageId() != null && this
						.getImageId().equals(castOther.getImageId())))
				&& ((this.getPhoneNumber() == castOther.getPhoneNumber()) || (this
						.getPhoneNumber() != null
						&& castOther.getPhoneNumber() != null && this
						.getPhoneNumber().equals(castOther.getPhoneNumber())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getStudentId() == castOther.getStudentId()) || (this
						.getStudentId() != null
						&& castOther.getStudentId() != null && this
						.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null && castOther.getClassId() != null && this
						.getClassId().equals(castOther.getClassId())))
				&& ((this.getChooseClassId() == castOther.getChooseClassId()) || (this
						.getChooseClassId() != null
						&& castOther.getChooseClassId() != null && this
						.getChooseClassId()
						.equals(castOther.getChooseClassId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		result = 37 * result
				+ (getUsersName() == null ? 0 : this.getUsersName().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result
				+ (getIsStudent() == null ? 0 : this.getIsStudent().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getWechatId() == null ? 0 : this.getWechatId().hashCode());
		result = 37 * result
				+ (getWeiboId() == null ? 0 : this.getWeiboId().hashCode());
		result = 37 * result
				+ (getImageId() == null ? 0 : this.getImageId().hashCode());
		result = 37
				* result
				+ (getPhoneNumber() == null ? 0 : this.getPhoneNumber()
						.hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37
				* result
				+ (getChooseClassId() == null ? 0 : this.getChooseClassId()
						.hashCode());
		return result;
	}

}