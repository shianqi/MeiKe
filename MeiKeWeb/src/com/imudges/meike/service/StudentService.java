package com.imudges.meike.service;

import java.util.List;

import com.imudges.meike.DAO.StudentDAO;
import com.imudges.meike.DAO.StudentUsersChooseclassDAO;
import com.imudges.meike.bean.Student;
import com.imudges.meike.bean.StudentUsersChooseclass;
import com.imudges.meike.bean.StudentUsersChooseclassId;
import com.imudges.meike.bean.Users;

public class StudentService {
	private Student student;
	public int findStudent(int usersId){
		StudentDAO studentDAO=new StudentDAO();
		List list=studentDAO.findByUsersId(usersId);
		if (list.isEmpty()) {
			return 104;
		}
		this.student=(Student)list.get(0);
		return 0;
	}
	public int findStudent(Users users){
		int usersId=users.getUsersId();
		StudentDAO studentDAO=new StudentDAO();
		List list=studentDAO.findByUsersId(usersId);
		if (list.isEmpty()) {
			return 104;
		}
		this.student=(Student)list.get(0);
		return 0;
	}
	public Student getStudent(){
		return this.student;
	}
	
	public void save(Student student){
		StudentDAO studentDAO=new StudentDAO();
		this.student=student;
		studentDAO.save(student);
	}
	
	public List getClassIdList (Users users){
		StudentUsersChooseclass studentUsersChooseclass=new StudentUsersChooseclass();
		studentUsersChooseclass.setUsersId(users.getUsersId());
		StudentUsersChooseclassDAO studentUsersChooseclassDAO=new StudentUsersChooseclassDAO();
		List list=studentUsersChooseclassDAO.findByExample(studentUsersChooseclass);
		return list;
	}
}
