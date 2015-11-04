package com.imudges.meike.webAction;

import com.imudges.meike.bean.Organization;
import com.imudges.meike.service.OrganizationService;
import com.opensymphony.xwork2.ActionSupport;

public class GetOrganizationInfoAction extends ActionSupport {
	int  organizationId;
	Organization organization = new Organization();
	
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	@Override
	public String execute() throws Exception {
		OrganizationService organizationservice = new OrganizationService();
		organization = organizationservice.getOrganization(organizationId);
		return SUCCESS;
	}
	
	
}
