package com.imudges.meike.action;

import java.util.List;
import com.imudges.meike.service.CommentService;
import com.opensymphony.xwork2.ActionSupport;

public class GetCommentByClassesIdAction extends ActionSupport{
	
	int classesId;
	List commentList;
	
	
	public List getCommentList() {
		return commentList;
	}

	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}



	public int getClassesId() {
		return classesId;
	}

	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CommentService commentService=new CommentService();
		List list=commentService.getComment(2, classesId);
		setCommentList(list);
		return SUCCESS;
	}
	
}
