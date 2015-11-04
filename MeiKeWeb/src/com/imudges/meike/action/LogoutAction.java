package com.imudges.meike.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.imudges.meike.model.StatusResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * µÇ³ö
 */
public class LogoutAction extends ActionSupport {
	private StatusResult logoutResult;
	
	
	public StatusResult getLogoutResult() {
		return logoutResult;
	}

	public void setLogoutResult(StatusResult logoutResult) {
		this.logoutResult = logoutResult;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public boolean removeCookie(){
		Cookie[] cookies= ServletActionContext.getRequest().getCookies();
		if (cookies==null) {
			return false;
		}
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("hashCode")) {
				cookies[i].setMaxAge(0);
			}
		}
		return false;
	}
	
}
