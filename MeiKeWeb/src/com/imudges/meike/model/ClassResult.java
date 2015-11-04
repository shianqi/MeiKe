package com.imudges.meike.model;

import java.sql.Time;
import java.util.Date;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Image;
import com.imudges.meike.service.ImageService;

public class ClassResult {
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
	private String url;
	private String intro;
	
	
	


	public ClassResult(Classes classes){
		this.classId=classes.getClassId();
		this.className=classes.getClassName();
		this.classType=classes.getClassType();
		this.ofOrganization=classes.getOfOrganization();
		this.imageId=classes.getImageId();
		this.description=classes.getDescription();
		this.position=classes.getPosition();
		this.quantity=classes.getQuantity();
		this.numbers=classes.getNumbers();
		this.startDate=classes.getStartDate();
		this.endDate=classes.getEndDate();
		this.duration=classes.getDuration();
		this.whichDayInWeek=classes.getWhichDayInWeek();
		this.latitude=classes.getLatitude();
		this.longitude=classes.getLongitude();
		this.city=classes.getCity();
		this.intro = classes.getIntro();
		url=new ImageService().getImage(classes);
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Integer getOfTeacherId() {
		return ofTeacherId;
	}

	public void setOfTeacherId(Integer ofTeacherId) {
		this.ofTeacherId = ofTeacherId;
	}

	public Integer getOfOrganization() {
		return ofOrganization;
	}

	public void setOfOrganization(Integer ofOrganization) {
		this.ofOrganization = ofOrganization;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDuration() {
		return duration.toString();
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getWhichDayInWeek() {
		return whichDayInWeek;
	}

	public void setWhichDayInWeek(String whichDayInWeek) {
		this.whichDayInWeek = whichDayInWeek;
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
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
