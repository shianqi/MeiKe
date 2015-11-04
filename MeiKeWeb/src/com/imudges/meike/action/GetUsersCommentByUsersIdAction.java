package com.imudges.meike.action;



import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.CommentUsers;
import com.imudges.meike.bean.Users;
import com.imudges.meike.service.CommentService;
import com.imudges.meike.utils.Loger;
import com.opensymphony.xwork2.ActionSupport;

public class GetUsersCommentByUsersIdAction extends ActionSupport{
	private CommentService commentservice = new CommentService();
	private int userid ;
	private List list;
	private String callback;
	private InputStream inputStream;
	
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public List<CommentUsers> getList() {
		return list;
	}
	public void setList(List<CommentUsers> list) {
		this.list = list;
	}
	

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		list=new ArrayList();
		setList(commentservice.getUsersComment(userid));
		Loger.addLog(userid,this,"得到了用户评论列表");
		if (callback == null||callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(list);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
	
}
