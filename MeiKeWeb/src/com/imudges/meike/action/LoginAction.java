package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpCookie;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.Users;
import com.imudges.meike.model.LoginResult;
import com.imudges.meike.service.ImageService;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * µÇÂ¼
 */
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private Users users;
	private String errorInfo;
	private String callback;
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	private LoginResult loginResult;

	public LoginResult getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(LoginResult loginResult) {
		this.loginResult = loginResult;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(callback);
		System.out.println(username);
		UsersService usersService = new UsersService();
		usersService.login(username, password);
		users = usersService.getCurrentUser();
		if (users == null) {
			loginResult = new LoginResult(new Users());
			loginResult.setLoginStatus(0);
		} else {
			loginResult = new LoginResult(usersService.getCurrentUser());
			loginResult.setLoginStatus(1);
			loginResult.setImagePath(new ImageService().getImage(users));
			Cookie cookie=new Cookie("hashCode", users.getHashCode());
			cookie.setMaxAge(60*60*24*365*5);
			cookie.setPath("/");
			ServletActionContext.getResponse().addCookie(cookie);
		}
		setLoginResult(loginResult);
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(loginResult);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}

	}

}
