package com.imudges.meike.bean;

import java.sql.Timestamp;

/**
 * MostSearchItemId entity. @author MyEclipse Persistence Tools
 */

public class MostSearchItemId implements java.io.Serializable {

	// Fields

	private String searchStr;
	private Timestamp searchDate;
	private Long showtimes;

	// Constructors

	/** default constructor */
	public MostSearchItemId() {
	}

	/** full constructor */
	public MostSearchItemId(String searchStr, Timestamp searchDate,
			Long showtimes) {
		this.searchStr = searchStr;
		this.searchDate = searchDate;
		this.showtimes = showtimes;
	}

	// Property accessors

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

	public Long getShowtimes() {
		return this.showtimes;
	}

	public void setShowtimes(Long showtimes) {
		this.showtimes = showtimes;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MostSearchItemId))
			return false;
		MostSearchItemId castOther = (MostSearchItemId) other;

		return ((this.getSearchStr() == castOther.getSearchStr()) || (this
				.getSearchStr() != null && castOther.getSearchStr() != null && this
				.getSearchStr().equals(castOther.getSearchStr())))
				&& ((this.getSearchDate() == castOther.getSearchDate()) || (this
						.getSearchDate() != null
						&& castOther.getSearchDate() != null && this
						.getSearchDate().equals(castOther.getSearchDate())))
				&& ((this.getShowtimes() == castOther.getShowtimes()) || (this
						.getShowtimes() != null
						&& castOther.getShowtimes() != null && this
						.getShowtimes().equals(castOther.getShowtimes())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSearchStr() == null ? 0 : this.getSearchStr().hashCode());
		result = 37
				* result
				+ (getSearchDate() == null ? 0 : this.getSearchDate()
						.hashCode());
		result = 37 * result
				+ (getShowtimes() == null ? 0 : this.getShowtimes().hashCode());
		return result;
	}

}