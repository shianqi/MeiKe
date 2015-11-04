package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Array;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.StudentUsersChooseclass;
import com.imudges.meike.bean.Users;
import com.imudges.meike.model.ClassResult;
import com.imudges.meike.service.ClassesService;
import com.imudges.meike.service.StudentService;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.GetUserIdByCookies;
import com.imudges.meike.utils.Loger;
import com.opensymphony.xwork2.ActionSupport;

public class GetUsersChooseClassesAction  extends ActionSupport{
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
		setUsersid(GetUserIdByCookies.getUserId(ServletActionContext.getRequest().getCookies()));
		//System.out.println(Usersid);
		result=new ArrayList();
		StudentService stdService = new StudentService();
		ClassesService claService = new ClassesService();
		UsersService userService = new UsersService();
		Users us = userService.getUsersById(Usersid);
		List list = stdService.getClassIdList(us);
		for(int i = 0 ;i<list.size();i++){
			StudentUsersChooseclass s = (StudentUsersChooseclass)list.get(i);
			System.out.println(s.getClassId());
			Classes classes = claService.getClassesById(s.getClassId());
			if(classes == null)
				continue;
			//System.out.println(classes.getClassName());
			if(!classes.isEnd()){
				result.add(new ClassResult(classes));
			}
		}
		Loger.addLog(Usersid,this,"得到了用户选课列表");
		if ( callback == null||callback.equals("")) {
			return SUCCESS;
		} else {
			JSONArray jsonArray=JSONArray.fromObject(result);
			System.out.println(jsonArray.toString());
			String string = new String(callback + "(" + jsonArray.toString() + ")");
			inputStream = new ByteArrayInputStream(string.getBytes("UTF-8"));
			return "callback";
		}
	}
	
	
}
