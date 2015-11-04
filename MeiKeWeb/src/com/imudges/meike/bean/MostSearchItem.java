package com.imudges.meike.bean;

import java.sql.Timestamp;

/**
 * MostSearchItem entity. @author MyEclipse Persistence Tools
 */

public class MostSearchItem implements java.io.Serializable {

	// Fields

	private MostSearchItemId id;
	private String searchStr;
	private Timestamp searchDate;
	private Long showtimes;
	// Constructors

	public String getSearchStr() {
		return id.getSearchStr();
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr ;
	}

	public Timestamp getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Timestamp searchDate) {
		this.searchDate = searchDate;
	}

	public Long getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Long showtimes) {
		this.showtimes = showtimes;
	}

	/** default constructor */
	public MostSearchItem() {
	}

	/** full constructor */
	public MostSearchItem(MostSearchItemId id) {
		this.id = id;
	}

	// Property accessors

	public MostSearchItemId getId() {
		return this.id;
	}

	public void setId(MostSearchItemId id) {
		this.id = id;
	}

}