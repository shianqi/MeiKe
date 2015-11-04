package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.imudges.meike.bean.Users;
import com.imudges.meike.model.StatusResult;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.ErrorInformation;
import com.imudges.meike.utils.GetUserIdByCookies;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserInfo extends ActionSupport{
	private String email;
	private String username;
	private StatusResult statusResult;
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

	public StatusResult getStatusResult() {
		return statusResult;
	}

	public void setStatusResult(StatusResult statusResult) {
		this.statusResult = statusResult;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		username=new String(username.getBytes("ISO-8859-1"),"utf-8");
		int userId=GetUserIdByCookies.getUserId(ServletActionContext.getRequest().getCookies());
		int errorCode=new UsersService().changeInfo(userId, username, email);
		statusResult=new StatusResult();
		
		System.out.println(username);
		if (errorCode==0) {
			statusResult.setStatus(1);
			statusResult.setResult("用户信息更新成功!");
		}else {
			statusResult.setStatus(0);
			statusResult.setResult(new ErrorInformation().getErrorInfo(errorCode));
		}
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(statusResult);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
}
