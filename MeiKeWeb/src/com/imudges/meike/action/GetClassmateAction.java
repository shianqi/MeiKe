package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.Users;
import com.imudges.meike.service.ClassesService;
import com.opensymphony.xwork2.ActionSupport;

public class GetClassmateAction extends ActionSupport {

	int classesId;
	List<Users> classmateList;
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
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	public List<Users> getClassmateList() {
		return classmateList;
	}
	public void setClassmateList(List<Users> classmateList) {
		this.classmateList = classmateList;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ClassesService classService = new ClassesService();
		classmateList = classService.getStudents(classesId);

		if (callback.equals("") || callback == null) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(classmateList);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}

}
