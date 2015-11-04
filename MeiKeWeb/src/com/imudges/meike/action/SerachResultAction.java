package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Organization;
import com.imudges.meike.model.SearchResult;
import com.imudges.meike.service.ClassesService;
import com.imudges.meike.service.ImageService;
import com.imudges.meike.service.OrganizationService;
import com.imudges.meike.service.SearchService;
import com.imudges.meike.utils.GetUserIdByCookies;
import com.opensymphony.xwork2.ActionSupport;

public class SerachResultAction extends ActionSupport{
	private String keyWord;
	private String city;
	private List resultList;
	private String callback;
	private InputStream inputStream;





	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
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


	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	

	public List getResultList() {
		return resultList;
	}


	public void setResultList(List resultList) {
		this.resultList = resultList;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		resultList=new ArrayList();
		String str = new String(keyWord.getBytes("ISO-8859-1"),"utf-8");
		if (city==null) {
			System.out.println("the city is null");
		}
		city=new String(city.getBytes("ISO-8859-1"),"utf-8");
		System.out.println(str);
		keyWord=str;
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		ClassesService classesService=new ClassesService();
		System.out.println(city);
		List classesList=classesService.findByKeyword(keyWord, city);
		for (int i = 0; i < classesList.size(); i++) {
			Classes classes=(Classes)classesList.get(i);
			SearchResult searchResult=new SearchResult(classes.getClassName(), classes.getDescription(),(short)2, classes.getClassId(),classes.getPosition(),new ImageService().getImage(classes));
			resultList.add(searchResult);
		}
		
		OrganizationService organizationService=new OrganizationService();
		List organizationList=organizationService.findByKeyword(keyWord, city);
		for (int i = 0; i < organizationList.size(); i++) {
			Organization organization=(Organization)organizationList.get(i);
			SearchResult searchResult=new SearchResult(organization.getOrganizationName(), organization.getDescription(), (short)3, organization.getOrganizationId(),organization.getAddress(),new ImageService().getImage(organization));
			resultList.add(searchResult);
		}

		if (callback==null||callback.equals("")) {
			return "ok";
		}else {
			JSONArray jsonArray=JSONArray.fromObject(resultList);
			System.out.println(jsonArray.toString());
			String string = new String(callback + "(" + jsonArray.toString() + ")");
			inputStream = new ByteArrayInputStream(string.getBytes("UTF-8"));
			return "callback";
		}
	}
	
}
