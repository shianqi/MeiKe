package com.imudges.meike.service;

import java.util.List;

import javax.enterprise.inject.spi.Bean;

import com.imudges.meike.DAO.TeacherDAO;
import com.imudges.meike.DAO.TeacherUserClassDAO;
import com.imudges.meike.bean.Teacher;
import com.imudges.meike.bean.TeacherUserClass;
import com.imudges.meike.bean.Users;

public class TeacherService {
	private Teacher teacher;
	int findTeacher(int usersId){
		TeacherDAO teacherDAO=new TeacherDAO();
		List list=teacherDAO.findByUsersId(usersId);
		if (list.isEmpty()) {
			return 103;
		}
		this.teacher=(Teacher)list.get(0);
		return 0;
	}
	int FindTeacher(Users users){
		int usersId =users.getUsersId();
		TeacherDAO teacherDAO=new TeacherDAO();
		List list=teacherDAO.findByUsersId(usersId);
		if (list.isEmpty()) {
			return 103;
		}
		this.teacher=(Teacher)list.get(0);
		return 0;
	}
	public Teacher getCurrentTeacher(){
		return this.teacher;
	}
	
	public void save(Teacher teacher){
		TeacherDAO teacherDAO=new TeacherDAO();
		teacherDAO.save(teacher);
		this.teacher=teacher;
	}
	
	public List getClassIdList(Users users){
		TeacherUserClass teacherUserClass=new TeacherUserClass();
		teacherUserClass.setUsersId(users.getUsersId());
		TeacherUserClassDAO teacherUserClassDAO=new  TeacherUserClassDAO();
		List list=teacherUserClassDAO.findByExample(teacherUserClass);
		return list;
	}

	public boolean isTeacher(int usersId) {
		
		return !(new TeacherDAO().findByUsersId(usersId).isEmpty());
	}
}