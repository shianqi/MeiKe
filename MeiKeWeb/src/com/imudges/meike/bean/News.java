package com.imudges.meike.bean;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer msgId;
	private Integer studentId;
	private String msg;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Integer studentId, String msg) {
		this.studentId = studentId;
		this.msg = msg;
	}

	// Property accessors

	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}