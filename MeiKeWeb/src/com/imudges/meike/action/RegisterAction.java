package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Provider.Service;
import java.util.Map;


import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.imudges.meike.bean.Student;
import com.imudges.meike.bean.Teacher;
import com.imudges.meike.bean.Users;
import com.imudges.meike.model.RegisterResult;
import com.imudges.meike.service.StudentService;
import com.imudges.meike.service.TeacherService;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.ErrorInformation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ×¢²áÓÃ»§
 */
public class RegisterAction extends ActionSupport {
	private String usersName;
	private String phoneNumber;
	private String password;
	private short isStudent=1;
	private String checkCode;
	private RegisterResult registerResult;
	private String callback;
	private InputStream inputStream;
	
	
	
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
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
	public RegisterResult getRegisterResult() {
		return registerResult;
	}
	public void setRegisterResult(RegisterResult registerResult) {
		this.registerResult = registerResult;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public short getIsStudent() {
		return isStudent;
	}
	public void setIsStudent(short isStudent) {
		this.isStudent = isStudent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		registerResult=new RegisterResult();
		UsersService usersService=new UsersService();
		System.out.println(phoneNumber);
		System.out.println(password);
		System.out.println(getCurrentPhoneNum());
		System.out.println(phoneNumber.equals(getCurrentPhoneNum()));
		int errorCode=usersService.register(usersName,getCurrentPhoneNum(),phoneNumber, password, checkCode, getCurrentCheckCode(),isStudent);
		if (errorCode==0){
			Users users=usersService.findByPhoneNum(phoneNumber);
			if (isStudent==1) {
				Student student=new Student();
				student.setUsersId(users.getUsersId());
				new StudentService().save(student);
			}else {
				if (isStudent==2) {
					Teacher teacher=new Teacher();
					teacher.setUsersId(users.getUsersId());
					new TeacherService().save(teacher);
				}
			}
			registerResult.setStatus(1);
			registerResult.setResult("×¢²á³É¹¦");
		}else {
			registerResult.setStatus(0);
			registerResult.setResult("×¢²áÊ§°Ü£¬Ê§°ÜÔ­Òò£º"+new ErrorInformation().getErrorInfo(errorCode));
		}
		setRegisterResult(registerResult);
		claerCheckCoede();
		if (callback==null || callback.equals("")) {
			return SUCCESS;
		} else {
			JSONObject jsonObj = JSONObject.fromObject(registerResult);
			System.out.println(jsonObj.toString());
			String str = new String(callback + "(" + jsonObj + ")");
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "callback";
		}
	}
	
	Map session=ActionContext.getContext().getSession();
	private String getCurrentCheckCode(){
		return (String)session.get("checkCode");
	}
	
	private String getCurrentPhoneNum(){	
		return (String)session.get("phoneNum");
	}
	
	private void claerCheckCoede(){
		session.clear();
	}
	
}
