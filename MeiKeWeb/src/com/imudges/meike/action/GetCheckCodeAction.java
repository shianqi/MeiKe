package com.imudges.meike.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.enterprise.inject.New;

import net.sf.json.JSONObject;

import com.imudges.meike.model.RegisterResult;
import com.imudges.meike.service.UsersService;
import com.imudges.meike.utils.SendMessage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetCheckCodeAction extends ActionSupport{

	String phoneNum;
	RegisterResult registerResult;
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

	public RegisterResult getRegisterResult() {
		return registerResult;
	}

	public void setRegisterResult(RegisterResult registerResult) {
		this.registerResult = registerResult;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		registerResult=new RegisterResult();
		
		if (phoneNum==null) {
			registerResult.setStatus(0);
			registerResult.setResult("未获取到用户的手机号");			
			setRegisterResult(registerResult);
			registerResult.setTime(-1);
		}else {
			if (new UsersService().findPhoneNum(phoneNum)) {
				//调用发送验证短信短信并存到session
				registerResult.setStatus(0);
				registerResult.setResult("该手机号已注册");
				registerResult.setTime(-1);
				setRegisterResult(registerResult);
			}else {
				if (new UsersService().checkPhoneNum(phoneNum)==false) {
					registerResult.setStatus(0);
					registerResult.setResult("手机号格式错误");
					setRegisterResult(registerResult);
					registerResult.setTime(-1);
					System.out.println(registerResult.getResult());
				}else {
					Map session=ActionContext.getContext().getSession();
					String sendTimeString;
					if ((String)session.get("time")==null) {
						sendTimeString="0";
					}else {
						sendTimeString=(String)session.get("time");
					}
					
					long sendTime=Long.parseLong(sendTimeString);
					long nowTime=System.currentTimeMillis();
					if ((nowTime-sendTime)>90*1000) {
						session.put("checkCode", new SendMessage().sendSMS(phoneNum));
						session.put("phoneNum", phoneNum);
						session.put("time", System.currentTimeMillis()+"");
						registerResult.setStatus(1);
						registerResult.setResult("验证码发送成功");
						registerResult.setTime(-1);
					}else {
						registerResult.setStatus(0);
						registerResult.setResult("您的请求过于频繁，请"+(int)(90-(nowTime-sendTime)/1000)+"秒后重试");
						registerResult.setTime((int)(90-(nowTime-sendTime)/1000));
					}
				}
			}
		}
		setRegisterResult(registerResult);
		System.out.println(registerResult.getResult());
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
	
}
