package com.imudges.meike.bean;

import java.sql.Timestamp;

/**
 * CommentUsers entity. @author MyEclipse Persistence Tools
 */

public class CommentUsers implements java.io.Serializable {

	// Fields

	private CommentUsersId id;
	private Integer typeId;
	private String comment;
	private Integer commentRank;
	private Timestamp commentDate;
	private Integer usersId;
	private Integer type;
	private String usersName;
	private Integer commentId;

	// Constructors

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentRank() {
		return commentRank;
	}

	public void setCommentRank(Integer commentRank) {
		this.commentRank = commentRank;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public Integer getCommentId() {
		return getId().getCommentId();
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	/** default constructor */
	public CommentUsers() {
	}

	/** full constructor */
	public CommentUsers(CommentUsersId id) {
		this.id = id;
	}

	// Property accessors

	public CommentUsersId getId() {
		return this.id;
	}

	public void setId(CommentUsersId id) {
		this.id = id;
	}

}