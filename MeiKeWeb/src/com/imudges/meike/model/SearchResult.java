package com.imudges.meike.model;

import java.sql.Time;
import java.util.Date;

import org.apache.struts2.components.If;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.service.ClassesService;
import com.imudges.meike.service.CommentService;

public class SearchResult {
	short type;
	String name;
	String description;
	int id;
	String position;
	String url;
	private Integer classId;
	private String className;
	private String classType;
	private Integer ofTeacherId;
	private Integer ofOrganization;
	private Integer imageId;
	private Integer quantity;
	private Integer numbers;
	private Date startDate;
	private Date endDate;
	private String whichDayInWeek;
	private Double latitude;
	private Double longitude;
	private String city;
	private int rank;
	private String rankString;
	private String starPath;
	
	

	public String getStarPath() {
		return starPath;
	}
	public void setStarPath(String starPath) {
		this.starPath = starPath;
	}
	public String getRankString() {
		return rankString;
	}
	public void setRankString(String rankString) {
		this.rankString = rankString;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SearchResult(String name,String description,short type,int id,String postion,String url){
		this.description=description;
		this.name=name;
		this.type=type;
		this.id=id;
		this.position=postion;
		this.url=url;
		Classes classes=new Classes();
		if (type==2) {
			classes=new ClassesService().getClassesById(id);
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
			//this.duration=classes.getDuration();
			this.whichDayInWeek=classes.getWhichDayInWeek();
			this.latitude=classes.getLatitude();
			this.longitude=classes.getLongitude();
			this.city=classes.getCity();
			this.rank=(int)new CommentService().getcommentRank(2, classId, true);
			this.rankString=new CommentService().getcommentRank(2, classId);
			this.starPath="img/star/star_"+rank+".jpg";
			System.out.println(rankString);
		}
	}
}
