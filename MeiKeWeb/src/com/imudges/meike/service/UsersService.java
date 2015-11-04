package com.imudges.meike.service;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.spi.RegisterableService;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.ls.LSInput;

import com.imudges.meike.DAO.UserimageDAO;
import com.imudges.meike.DAO.UsersDAO;
import com.imudges.meike.bean.UserimageId;
import com.imudges.meike.bean.Users;
import com.imudges.meike.utils.MD5;
import com.imudges.meike.utils.SendEmail;

public class UsersService {
	Users users=null;
	List list;
	public boolean login(String loginName,String password){
		if (loginName==null||password==null) {
			return false;
		}/*
		users.setEmail(loginName);
		users.setPassword(password);
		List list=usersDAO.findByExample(users);
		if (list!=null) {
			if (!list.isEmpty()) {
				this.users=(Users)list.get(0);
				return true;
			}
		}*/
		Users users=new Users();
		UsersDAO usersDAO=new UsersDAO();
		users.setPhoneNumber(loginName);
		users.setEmail(null);
		users.setPassword(password);
		list=usersDAO.findByExample(users);
		if (list!=null) {
			if (!list.isEmpty()) {
				this.users=(Users)list.get(0);
				this.users.setHashCode(new MD5().Md5(users.getUsersName() + users.getPhoneNumber() + System.currentTimeMillis()));
				usersDAO.save(this.users);
				return true;
			}
		}
		users.setUsersName(loginName);
		users.setPassword(password);
		users.setPhoneNumber(null);
		users.setEmail(null);
		list=usersDAO.findByExample(users);
		if (list!=null) {
			if (!list.isEmpty()) {
				this.users=(Users)list.get(0);
				this.users.setHashCode(new MD5().Md5(users.getUsersName() + users.getPhoneNumber() + System.currentTimeMillis()));
				usersDAO.save(this.users);
				return true;
			}
		}
		return false;
	}
	/*public List DimfindByName(String key){
		UsersDAO usersDAO=new UsersDAO();
		return usersDAO.dimFindByName(key);
	}*/
	public int register(String usersName,String currentPhoneNum,String phoneNumber,String password,String checkCode,String currentCheckCode,Short isStudent){
		if (checkCode==null||currentCheckCode==null) {
			return 106;
		}
		if (currentPhoneNum==null||phoneNumber==null) {
			return 108;
		}
		if (!currentPhoneNum.equals(phoneNumber)) {
			return 109;
		}
		if (usersName==null) {
			return 107;
		}
		if (!currentCheckCode.equals(checkCode)) {
			return 105;
		}
		if (phoneNumber.length()!=11) {
			return 100;
		}
		if (findUsersName(usersName)) {
			return 110;
		}
		if (findPhoneNum(phoneNumber)) {
			return 101;
		}
		String str="123456";
		boolean result=str.matches("[0-9]+");
		if (result == true) { 
		System.out.println("该字符串是纯数字");
		}else{
		System.out.println("该字符串不是纯数字");
		}
		Users users=new Users();
		users.setUsersName(usersName);
		users.setPhoneNumber(phoneNumber);
		users.setPassword(password);
		users.setIsStudent(isStudent);
		users.setName(usersName);
		UsersDAO usersDAO=new UsersDAO();
		usersDAO.save(users);
		return 0;
	}
	
	public Users getCurrentUser(){
		if (users!=null) {
			users.setPassword(null);
		}
		return this.users;
	}
	
	public Users getUsersById(int usersId){
		return new UsersDAO().findById(usersId);
	}
	
	public boolean findPhoneNum(String phoneNum){
		users=new Users();
		users.setPhoneNumber(phoneNum);
		UsersDAO usersDAO=new UsersDAO();
		List list=usersDAO.findByExample(users);
		if (list==null) {
			return false;
		}
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean findUsersName(String usersName){
		users=new Users();
		users.setUsersName(usersName);
		UsersDAO usersDAO=new UsersDAO();
		List list=usersDAO.findByExample(users);
		if (list==null) {
			return false;
		}
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public Users findByPhoneNum(String phoneNum){
		users=new Users();
		users.setPhoneNumber(phoneNum);
		UsersDAO usersDAO=new UsersDAO();
		List list=usersDAO.findByExample(users);
		if (list.get(0)!=null) {
			return (Users)list.get(0);
		}else {
			return new Users();
		}
	}
	
	public boolean checkPhoneNum(String phoneNum){
		String value=phoneNum;  
		String regExp = "^[1]([3][0-9]{1}|71|72|73|74|75|76|77|78|79|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|80|81|82|83|84|85|86|87|88|89)[0-9]{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(value);
		if (m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Users getUsersByUsersName(String usersName){
		UsersDAO usersDAO=new UsersDAO();
		Users users=new Users();
		users.setUsersName(usersName);
		List list=usersDAO.findByExample(users);
		return (Users)list.get(0);
	}
	
	public int changePassword(int userid,String oldPassword,String newPassword1,String newPassword2){
		if (oldPassword==null||newPassword1 ==null||newPassword2==null) {
			return 113;
		}
		if (!newPassword1 .equals(newPassword2)) {
			return 114;
		}
		if (userid==0) {
			return 111;
		}
		Users users=getUsersById(userid);
		System.out.println("数据库密码"+users.getPassword());
		System.out.println("输入的原密码"+oldPassword);
		if (!users.getPassword().equals(oldPassword)) {
			System.out.println(users.getPassword());
			System.out.println(oldPassword);
			return 112;
		}
		users.setPassword(newPassword1);
		UsersDAO usersDAO=new UsersDAO();
		usersDAO.save(users);
		return 0;
	}
	
	public int changeInfo(int userId,String name,String email){
		if (userId==0) {
			return 111;
		}
		if (name==null||email==null) {
			return 115;
		}
		System.out.println("email:"+email);
		if (email.equals("undefined")) {
			return 116;
		}
		if (findByMail(email)) {
			return 117;
		}
		Users users=getUsersById(userId);
		if (email.equals("DONOTCHANGE")) {
			users.setName(name);
		}
		if (name==null||name.equals("")) {
			users.setEmail(email);
			users.setEmailStatus(0);
			String key=System.currentTimeMillis()+"";
			SendEmail.send(email, new MD5().Md5(key));
			users.setSendTime(key);
		}
		UsersDAO usersDAO=new UsersDAO();
		usersDAO.save(users);
		return 0;
	}
	
	
	public Users getUsersByHashCode(String hashCode) {
		users=new Users();
		users.setHashCode(hashCode);
		UsersDAO usersDAO=new UsersDAO();
		List list=usersDAO.findByExample(users);
		if (list==null) {
			return null;
		}
		if (list.isEmpty()) {
			return null;
		}
		return (Users)list.get(0);
	}
	
	
	public boolean findByMail(String email){
		Users users=new Users();
		users.setEmail(email);
		List list=new UsersDAO().findByExample(users);
		if (list==null) {
			return false;
		}
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public Users getUsersByMail(String email){
		Users users=new Users();
		users.setEmail(email);
		List list=new UsersDAO().findByExample(users);
		if (list==null) {
			return null;
		}
		if (list.isEmpty()) {
			return null;
		}
		return (Users)list.get(0);
	}
	
	public boolean activeEmail(String email,String key){
		if (findByMail(email)==false) {
			return false;
		}
		Users users=getUsersByMail(email);
		if (users.getSendTime()==null) {
			return false;
		}
		System.out.println("md5:"+new MD5().Md5(users.getSendTime()));
		System.out.println("key:"+key);
		if (new MD5().Md5(users.getSendTime()).equals(key)) {
			long sendTime=Long.parseLong(users.getSendTime());
			if (System.currentTimeMillis()-sendTime<1000*60*60*48) {
				users.setEmailStatus(1);
				users.setSendTime("10203040");
				UsersDAO usersDAO=new UsersDAO();
				usersDAO.save(users);
				return true;
			}else {
				return false;
			}
		
		}
		return false;
	}
}
