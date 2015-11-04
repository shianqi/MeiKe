package com.imudges.meike.webAction;

import com.imudges.meike.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

public class ActiveEmailAction extends ActionSupport{
	private String email;
	private String key;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (new UsersService().activeEmail(email, key)) {
			return SUCCESS;
		}else {
			return ERROR;
		}
		
	}
	
}
