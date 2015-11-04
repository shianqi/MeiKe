package com.imudges.meike.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.junit.Test;
import org.objectweb.asm.xwork.tree.TryCatchBlockNode;

public class SendMessage {
	
	private String checkCode;
	
	private void createCheckCode(){
		checkCode="";
		String base[] = {"0","1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < 4; i++) {
			int RandNum=new Random().nextInt(base.length);
			this.checkCode+=base[RandNum];
		}
	}
	private String getCheckCode(){
		return checkCode;
	}
	public String sendSMS(String phoneNum){
		String username = "yanyongjie";//短信宝帐户名
		String pass = new MD5().Md5("15296603340yyjqq");//短信宝帐户密码，md5加密后的字符串
		String phone = phoneNum;//电话号码
		String content="";
		try {
			createCheckCode();
			content = java.net.URLEncoder.encode("【美课】你的验证码为"+getCheckCode()+"，请勿将验证码透露给其他人。","utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//发送内容
		httpSend send = new httpSend("http://www.smsbao.com/sms?u="+username+"&p="+pass+"&m="+phone+"&c="+content);
		try {
			send.send();
		} catch (Exception e) {
			e.printStackTrace();
		}/**/
		return checkCode;
	}

}