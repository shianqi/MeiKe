package com.imudges.meike.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imudges.meike.DAO.ChooseclassDAO;
import com.imudges.meike.DAO.ClassesDAO;
import com.imudges.meike.DAO.ClassesimageDAO;
import com.imudges.meike.DAO.StudentUsersChooseclassDAO;
import com.imudges.meike.DAO.TeacherDAO;
import com.imudges.meike.DAO.TeacherUserClassDAO;
import com.imudges.meike.DAO.UsersDAO;
import com.imudges.meike.bean.Chooseclass;
import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.ClassesimageId;
import com.imudges.meike.bean.StudentUsersChooseclass;
import com.imudges.meike.bean.StudentUsersChooseclassId;
import com.imudges.meike.bean.Teacher;
import com.imudges.meike.bean.TeacherUserClass;
import com.imudges.meike.bean.Users;

public class ClassesService {

	private ClassesimageDAO daoCI = new ClassesimageDAO();
	private ClassesDAO daoC = new ClassesDAO();
	private ChooseclassDAO daoCC= new ChooseclassDAO();
	private StudentUsersChooseclassDAO daoSUCC = new StudentUsersChooseclassDAO();
	private UsersDAO daoU = new UsersDAO();
	private TeacherDAO daoT = new TeacherDAO();
	private TeacherUserClassDAO daoTUC = new TeacherUserClassDAO();

	
	public String getImageURL(int classId) {
		
		
		return new ImageService().getImage(daoC.findById(classId));
	}
	
	public Classes getClassesById(int classId) {
		
		return daoC.findById(classId);
	}
	
	public List<Classes> findByKeyword(String keyword, String city) {
		
		System.out.println(keyword + ":" + city);
		List<Classes> list = daoC.findByKeyword(keyword, city);
		return list;
	}
	
	public List<Classes> findByCity(String city) {
		
		return daoC.findByCity(city);
	}
	
	public int chooseClasses(int classId, int studentId) {
		
		Classes c = daoC.findById(classId);
		if (c == null) {
			return 301;
		} if(c.isEnd()) {
			return 302;
		} else if(c.isFull()) {
			return 303;
		} else {
			Chooseclass cc = new Chooseclass();
			cc.setStudentId(studentId);
			cc.setClassId(classId);
			if(!daoCC.findByExample(cc).isEmpty())
				return 304;
			daoCC.save(cc);
			c.addNumbers();
			daoC.save(c);
			return 0;
		}
	}
	
	public int addClasses(String className, String classType, 
			int ofTeacherId, int ofOrganization, String describe,
			String position, int quantity, Date startDate,
			Date endDate,Time duration, String whichDayInWeek, String city, String intro) {
		
		Classes c = new Classes();
		c.setClassName(className);
		c.setClassType(classType);
		c.setOfTeacherId(ofTeacherId);
		c.setOfOrganization(ofOrganization);
		c.setDescription(describe);
		c.setPosition(position);
		c.setQuantity(quantity);
		c.setStartDate(startDate);
		c.setEndDate(endDate);
		c.setWhichDayInWeek(whichDayInWeek);
		c.setNumbers(0);
		c.setClassId(1);
		c.setDuration(duration);
		c.setCity(city);
		c.setIntro(intro);
		daoC.save(c);
		return c.getClassId();
	}
	
	public String delClasses(int classId) {
		
		Classes c = daoC.findById(classId);
		if(c != null) {
			daoC.delete(c);
			return "success";
		} else {
			return "error";
		}
	}
	
	public String modifyClasses(int classId, String className, String classType, 
			int ofTeacherId,  String describe,
			String position, int quantity, Date startDate,
			Date endDate, String whichDayInWeek, String city, String intro) {
		
		Classes c = daoC.findById(classId);
		if(c == null)
			return "error";
		c.setClassName(className);
		c.setClassType(classType);
		c.setOfTeacherId(ofTeacherId);
		c.setDescription(describe);
		c.setPosition(position);
		c.setStartDate(startDate);
		c.setEndDate(endDate);
		c.setWhichDayInWeek(whichDayInWeek);
		c.setCity(city);
		c.setIntro(intro);
		if(quantity >= c.getNumbers())
			c.setQuantity(quantity);
		daoC.save(c);
		return "success";
	}
	
	public List<Users> getStudents(int classId) {
		
		StudentUsersChooseclass succ = new StudentUsersChooseclass();
		succ.setClassId(classId);
		@SuppressWarnings("unchecked")
		List<StudentUsersChooseclass> listSUCC = daoSUCC.findByExample(succ);
		List<Users> newList = new ArrayList<Users>();
		for(int i = 0; i < listSUCC.size(); i++) {
			succ = listSUCC.get(i);
			Users u = new Users();
			u.setName(succ.getName());
			u.setEmail(succ.getEmail());
			//u.setImageId(succ.getImageId());
			u.setPhoneNumber(succ.getPhoneNumber());
			u.setUsersId(succ.getUsersId());
			u.setWechatId(succ.getWechatId());
			u.setWeiboId(succ.getWeiboId());
			newList.add(u);
		}
		return newList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Classes> getAllClasses() {
		
		return daoC.findAll();
	}
	
	public boolean isChecked(int usersId, int classId) {
		
		Chooseclass chooseClass = new Chooseclass();
		chooseClass.setClassId(classId);
		List<StudentUsersChooseclass> list = daoSUCC.findByProperty("usersId", usersId);
		return !list.isEmpty();
	}
	
	public Users getTecher(int classId) {
		
		Classes c = daoC.findById(classId);
		List<TeacherUserClass> listTUC = daoTUC.findByProperty("classId", classId);
		if(listTUC.isEmpty())
			return null;
		return daoU.findById(listTUC.get(0).getUsersId());
	}
}
