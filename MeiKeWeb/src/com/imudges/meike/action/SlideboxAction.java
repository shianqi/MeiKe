package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import com.imudges.meike.bean.Slidebox;
import com.imudges.meike.service.SlideboxService;
import com.opensymphony.xwork2.ActionSupport;

public class SlideboxAction extends ActionSupport{
	private String callback;
	private InputStream inputStream;
	private Slidebox slidebox;
	
	
	
	public Slidebox getSlidebox() {
		return slidebox;
	}

	public void setSlidebox(Slidebox slidebox) {
		this.slidebox = slidebox;
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
		setSlidebox(new SlideboxService().getSlideboxService());
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(slidebox);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
	
}
