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

public class ChangePasswordAction extends ActionSupport {

	int usersId;
	String oldPassword;
	String newPassword;
	String repeatPassword;
	StatusResult result;
	String callback;
	InputStream inputStream;
	
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public StatusResult getResult() {
		return result;
	}
	public void setResult(StatusResult result) {
		this.result = result;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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
		result=new StatusResult();
		setUsersId(GetUserIdByCookies.getUserId(ServletActionContext.getRequest().getCookies()));
		UsersService usersService = new UsersService();
		int statusCode = usersService.changePassword(usersId, oldPassword, newPassword, repeatPassword);
		if(statusCode == 0) {
			result.setStatus(1);
			result.setResult("ÐÞ¸ÄÃÜÂë³É¹¦");
		} else {
			result.setStatus(0);
			result.setResult(new ErrorInformation().getErrorInfo(statusCode));
		}

		if (callback == null || callback.equals("") ) {
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
