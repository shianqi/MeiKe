package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Slidebox;
import com.imudges.meike.model.ClassResult;
import com.imudges.meike.service.ClassesService;
import com.opensymphony.xwork2.ActionSupport;

public class GetClassesInfo extends ActionSupport{

	int classId;
	private InputStream inputStream;
	private String callback;
	private Classes classes;
	private ClassResult classResult;
	
	
	
	
	public ClassResult getClassResult() {
		return classResult;
	}

	public void setClassResult(ClassResult classResult) {
		this.classResult = classResult;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}



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



	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ClassesService classesService=new ClassesService();
		classes=(classesService.getClassesById(classId)); 
		System.out.println(classes.getClassName());
		classResult=new ClassResult(classes);
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(classResult);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
	
}
