package com.action;

import com.model.PersonData;
import com.opensymphony.xwork2.ActionSupport;

public class AngularAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PersonData personData = new PersonData();
	  public String execute() {
	    personData.setFirstName("Mohaideen");
	    personData.setLastName("Jamil");
	    return SUCCESS;
	  }
	  public PersonData getPersonData() {
	    return personData;
	  }
	  public void setPersonData(PersonData personData) {
	    this.personData = personData;
	  }
}
