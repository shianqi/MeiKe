package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Organization;
import com.imudges.meike.model.ClassResult;
import com.imudges.meike.service.OrganizationService;
import com.opensymphony.xwork2.ActionSupport;

public class GetOrganizationInfoAction extends ActionSupport {

	int organizationId;
	private InputStream inputStream;
	private String callback;
	private Organization result;
	
	
	
	
	public int getOrganizationId() {
		return organizationId;
	}




	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}




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




	public Organization getResult() {
		return result;
	}




	public void setResult(Organization result) {
		this.result = result;
	}




	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		OrganizationService organizationService = new OrganizationService();
		setResult(organizationService.getOrganization(organizationId));
		if (callback==null || callback.equals("")) {
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
