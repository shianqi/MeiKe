package com.imudges.meike.webAction;

import com.imudges.meike.service.OrganizationService;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyOrganizationAction extends ActionSupport {
	int organizationId;
	String organizationName;
	String description;
	String city;
	String address;
	String tel;
	String result;
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		OrganizationService organizationservice = new OrganizationService();
		result = organizationservice.modifyOrganization(organizationId, organizationName,
				description, city, address, tel);
		return SUCCESS;
	}
	
}
