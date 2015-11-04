package com.imudges.meike.bean;

import java.sql.Timestamp;

/**
 * Search entity. @author MyEclipse Persistence Tools
 */

public class Search implements java.io.Serializable {

	// Fields

	private Integer searchId;
	private String searchStr;
	private Timestamp searchDate;

	// Constructors

	/** default constructor */
	public Search() {
	}

	/** full constructor */
	public Search(String searchStr, Timestamp searchDate) {
		this.searchStr = searchStr;
		this.searchDate = searchDate;
	}

	// Property accessors

	public Integer getSearchId() {
		return this.searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public String getSearchStr() {
		return this.searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public Timestamp getSearchDate() {
		return this.searchDate;
	}

	public void setSearchDate(Timestamp searchDate) {
		this.searchDate = searchDate;
	}

}