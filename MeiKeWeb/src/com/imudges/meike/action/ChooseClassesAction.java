package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.imudges.meike.model.StatusResult;
import com.imudges.meike.service.ClassesService;
import com.imudges.meike.service.StudentService;
import com.imudges.meike.utils.ErrorInformation;
import com.imudges.meike.utils.GetUserIdByCookies;
import com.imudges.meike.utils.Loger;
import com.opensymphony.xwork2.ActionSupport;

public class ChooseClassesAction extends ActionSupport {

	
	int usersId;
	int classesId;
	StatusResult result = new StatusResult();
	private String callback;
	private InputStream inputStream;
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
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		setUsersId(GetUserIdByCookies.getUserId(ServletActionContext.getRequest().getCookies()));
		if(usersId == 0){
			result.setStatus(0);
			result.setResult("cookies失效，请重新登录");
		} else {
			System.out.println("usersId:" + usersId + " classesId:" +classesId);
			ClassesService classesService = new ClassesService();
			StudentService studentService = new StudentService();
			studentService.findStudent(usersId);
			int statusCode = classesService.chooseClasses(classesId, studentService.getStudent().getStudentId());
			if(statusCode == 0) {
				System.out.println("loged");
				Loger.addLog(usersId, this, "classId:" + classesId);
				result.setStatus(1);
				result.setResult("选课成功");
			} else {
				result.setStatus(0);
				result.setResult(new ErrorInformation().getErrorInfo(statusCode));
			}
		}
		if (callback == null || callback.equals("") ) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(result);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
	public StatusResult getResult() {
		return result;
	}
	public void setResult(StatusResult result) {
		this.result = result;
	}

	
}
