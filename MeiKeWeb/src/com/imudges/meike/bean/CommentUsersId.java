package com.imudges.meike.bean;

import java.sql.Timestamp;

/**
 * CommentUsersId entity. @author MyEclipse Persistence Tools
 */

public class CommentUsersId implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String comment;
	private Integer commentRank;
	private Timestamp commentDate;
	private Integer usersId;
	private Integer type;
	private String usersName;
	private Integer commentId;

	// Constructors

	/** default constructor */
	public CommentUsersId() {
	}

	/** minimal constructor */
	public CommentUsersId(Integer typeId, String comment, Integer commentRank,
			Timestamp commentDate, Integer usersId, Integer type,
			Integer commentId) {
		this.typeId = typeId;
		this.comment = comment;
		this.commentRank = commentRank;
		this.commentDate = commentDate;
		this.usersId = usersId;
		this.type = type;
		this.commentId = commentId;
	}

	/** full constructor */
	public CommentUsersId(Integer typeId, String comment, Integer commentRank,
			Timestamp commentDate, Integer usersId, Integer type,
			String usersName, Integer commentId) {
		this.typeId = typeId;
		this.comment = comment;
		this.commentRank = commentRank;
		this.commentDate = commentDate;
		this.usersId = usersId;
		this.type = type;
		this.usersName = usersName;
		this.commentId = commentId;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentRank() {
		return this.commentRank;
	}

	public void setCommentRank(Integer commentRank) {
		this.commentRank = commentRank;
	}

	public Timestamp getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUsersName() {
		return this.usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentUsersId))
			return false;
		CommentUsersId castOther = (CommentUsersId) other;

		return ((this.getTypeId() == castOther.getTypeId()) || (this
				.getTypeId() != null && castOther.getTypeId() != null && this
				.getTypeId().equals(castOther.getTypeId())))
				&& ((this.getComment() == castOther.getComment()) || (this
						.getComment() != null && castOther.getComment() != null && this
						.getComment().equals(castOther.getComment())))
				&& ((this.getCommentRank() == castOther.getCommentRank()) || (this
						.getCommentRank() != null
						&& castOther.getCommentRank() != null && this
						.getCommentRank().equals(castOther.getCommentRank())))
				&& ((this.getCommentDate() == castOther.getCommentDate()) || (this
						.getCommentDate() != null
						&& castOther.getCommentDate() != null && this
						.getCommentDate().equals(castOther.getCommentDate())))
				&& ((this.getUsersId() == castOther.getUsersId()) || (this
						.getUsersId() != null && castOther.getUsersId() != null && this
						.getUsersId().equals(castOther.getUsersId())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())))
				&& ((this.getUsersName() == castOther.getUsersName()) || (this
						.getUsersName() != null
						&& castOther.getUsersName() != null && this
						.getUsersName().equals(castOther.getUsersName())))
				&& ((this.getCommentId() == castOther.getCommentId()) || (this
						.getCommentId() != null
						&& castOther.getCommentId() != null && this
						.getCommentId().equals(castOther.getCommentId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTypeId() == null ? 0 : this.getTypeId().hashCode());
		result = 37 * result
				+ (getComment() == null ? 0 : this.getComment().hashCode());
		result = 37
				* result
				+ (getCommentRank() == null ? 0 : this.getCommentRank()
						.hashCode());
		result = 37
				* result
				+ (getCommentDate() == null ? 0 : this.getCommentDate()
						.hashCode());
		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result
				+ (getUsersName() == null ? 0 : this.getUsersName().hashCode());
		result = 37 * result
				+ (getCommentId() == null ? 0 : this.getCommentId().hashCode());
		return result;
	}

}