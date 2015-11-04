package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.Cookie;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.imudges.meike.bean.Users;
import com.imudges.meike.model.LoginResult;
import com.imudges.meike.service.ImageService;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.GetUserIdByCookies;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserInfoAction extends ActionSupport{

	Users users;
	LoginResult loginResult;
	String callback;
	InputStream inputStream;
	
	
	
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

	public LoginResult getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(LoginResult loginResult) {
		this.loginResult = loginResult;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UsersService usersService=new UsersService();
		int userId=GetUserIdByCookies.getUserId(ServletActionContext.getRequest().getCookies());
		loginResult=new LoginResult(usersService.getUsersById(userId));
		loginResult.setLoginStatus(1);
		loginResult.setImagePath(new ImageService().getImage(usersService.getUsersById(userId)));
		loginResult.setPassword(null);
		setLoginResult(loginResult);
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(loginResult);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "([" + jsonObj + "])");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
	
}
