package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Log;
import com.imudges.meike.bean.StudentUsersChooseclass;
import com.imudges.meike.bean.Users;
import com.imudges.meike.service.ClassesService;
import com.imudges.meike.service.StudentService;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.Loger;
import com.opensymphony.xwork2.ActionSupport;

public class GetLastClassesList  extends ActionSupport{
	private int Usersid;
	private List result;
	private String callback;
	private InputStream inputStream;

	
	public int getUsersid() {
		return Usersid;
	}
	public void setUsersid(int usersid) {
		Usersid = usersid;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
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
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		result=new ArrayList();
		StudentService stdService = new StudentService();
		ClassesService claService = new ClassesService();
		UsersService userService = new UsersService();
		Users us = userService.getUsersById(Usersid);
		List list = stdService.getClassIdList(us);
		for(int i = 0 ;i<list.size();i++){
			StudentUsersChooseclass s = (StudentUsersChooseclass)list.get(i);
			Classes classes = claService.getClassesById(s.getClassId());
			if(classes.isEnd()){
				result.add(classes);
			}
		}
		Loger.addLog(Usersid,this, "得到了历史课程列表");
		if (callback == null||callback.equals("")) {
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
