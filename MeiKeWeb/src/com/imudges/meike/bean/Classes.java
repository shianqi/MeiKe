package com.imudges.meike.bean;

import java.sql.Time;
import java.util.Date;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classId;
	private String className;
	private String classType;
	private Integer ofTeacherId;
	private Integer ofOrganization;
	private Integer imageId;
	private String description;
	private String position;
	private Integer quantity;
	private Integer numbers;
	private Date startDate;
	private Date endDate;
	private Time duration;
	private String whichDayInWeek;
	private Double latitude;
	private Double longitude;
	private String city;
	private String intro;

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(String className, String classType, Integer ofTeacherId,
			Integer ofOrganization, String description, String position,
			Integer quantity, Integer numbers, Date startDate, Date endDate,
			Time duration) {
		this.className = className;
		this.classType = classType;
		this.ofTeacherId = ofTeacherId;
		this.ofOrganization = ofOrganization;
		this.description = description;
		this.position = position;
		this.quantity = quantity;
		this.numbers = numbers;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
	}

	/** full constructor */
	public Classes(String className, String classType, Integer ofTeacherId,
			Integer ofOrganization, Integer imageId, String description,
			String position, Integer quantity, Integer numbers, Date startDate,
			Date endDate, Time duration, String whichDayInWeek,
			Double latitude, Double longitude, String city, String intro) {
		this.className = className;
		this.classType = classType;
		this.ofTeacherId = ofTeacherId;
		this.ofOrganization = ofOrganization;
		this.imageId = imageId;
		this.description = description;
		this.position = position;
		this.quantity = quantity;
		this.numbers = numbers;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.whichDayInWeek = whichDayInWeek;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.intro = intro;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassType() {
		return this.classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Integer getOfTeacherId() {
		return this.ofTeacherId;
	}

	public void setOfTeacherId(Integer ofTeacherId) {
		this.ofTeacherId = ofTeacherId;
	}

	public Integer getOfOrganization() {
		return this.ofOrganization;
	}

	public void setOfOrganization(Integer ofOrganization) {
		this.ofOrganization = ofOrganization;
	}

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getNumbers() {
		return this.numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getDuration() {
		return this.duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getWhichDayInWeek() {
		return this.whichDayInWeek;
	}

	public void setWhichDayInWeek(String whichDayInWeek) {
		this.whichDayInWeek = whichDayInWeek;
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

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public boolean isFull() {
		return this.numbers >= this.quantity;
	}
	
	public boolean isEnd() {
		Date d = new Date(System.currentTimeMillis());
		return d.after(endDate);
	}
	
	public void addNumbers() {
		numbers++;
	}

}