package com.imudges.meike.bean;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer usersId;
	private String comment;
	private Integer commentRank;
	private Integer type;
	private Integer typeId;
	private Timestamp commentDate;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Integer usersId, String comment, Integer commentRank,
			Integer type, Integer typeId, Timestamp commentDate) {
		this.usersId = usersId;
		this.comment = comment;
		this.commentRank = commentRank;
		this.type = type;
		this.typeId = typeId;
		this.commentDate = commentDate;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Timestamp getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

}