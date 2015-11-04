package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.imudges.meike.service.ClassesService;
import com.imudges.meike.utils.GetUserIdByCookies;
import com.opensymphony.xwork2.ActionSupport;

public class GetUsersIsChooseClass extends ActionSupport {

	
	int usersId;
	int classId;
	boolean result;
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



	public boolean isResult() {
		return result;
	}



	public void setResult(boolean result) {
		this.result = result;
	}



	public int getUsersId() {
		return usersId;
	}



	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}



	public int getClassId() {
		return classId;
	}



	public void setClassId(int classId) {
		this.classId = classId;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		setUsersId(GetUserIdByCookies.getUserId(ServletActionContext.getRequest().getCookies()));
		
		ClassesService classesService = new ClassesService();
		setResult(classesService.isChecked(usersId, classId));
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(result);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}

}
