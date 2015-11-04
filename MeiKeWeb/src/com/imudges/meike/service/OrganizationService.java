package com.imudges.meike.service;

import java.util.ArrayList;
import java.util.List;

import com.imudges.meike.DAO.OrganizationClassesTeacherDAO;
import com.imudges.meike.DAO.OrganizationDAO;
import com.imudges.meike.DAO.OrganizationTeacherDAO;
import com.imudges.meike.DAO.OrganizationUsersDAO;
import com.imudges.meike.DAO.TeacherDAO;
import com.imudges.meike.DAO.UsersDAO;
import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Organization;
import com.imudges.meike.bean.OrganizationClassesTeacher;
import com.imudges.meike.bean.OrganizationTeacher;
import com.imudges.meike.bean.Teacher;
import com.imudges.meike.bean.Users;

public class OrganizationService {

	private OrganizationDAO daoO = new OrganizationDAO();
	private OrganizationClassesTeacherDAO daoOCT = new OrganizationClassesTeacherDAO();
	private UsersDAO daoU = new UsersDAO();
	private OrganizationUsersDAO daoOU = new OrganizationUsersDAO();
	private TeacherDAO daoT = new TeacherDAO();
	private OrganizationTeacherDAO daoOT = new OrganizationTeacherDAO();
	
	public Organization getOrganization(int organizationId) {
		
		return daoO.findById(organizationId);
	}
	
	public boolean isOfOrganization(int organizationId, int usersId) {
		
		OrganizationTeacher ot = new OrganizationTeacher();
		ot.setOrganizationId(organizationId);
		ot.setUsersId(usersId);
		return !daoOT.findByExample(ot).isEmpty();
	}
	
	public String setStudentToTeacher(int organizationId, int usersId) {
		
		Users u = daoU.findById(usersId);
		if(u == null) {
			return "error";
		} else if(u.getIsStudent() == 1 && !isOrganization(usersId)) {
			u.setIsStudent((short) 2);
			Teacher teacher = new Teacher();
			teacher.setUsersId(usersId);
			teacher.setOfOrganizationId(organizationId);
			new TeacherService().save(teacher);
			daoU.save(u);
			return "success";
		} else {
			return "error";
		}
	}
	
	
	public String setTeacherToStudent(int organizationId, int usersId) {
		
		if(!isOfOrganization(organizationId, usersId))
			return "error";
		if(!new TeacherService().isTeacher(usersId))
			return "error";
		if(daoT.findByUsersId(usersId).isEmpty())
			return "error";
		List<Teacher> teacherList = daoT.findByUsersId(usersId);
		if(teacherList.isEmpty())
			return "error";
		Teacher t = teacherList.get(0);
		System.out.println(t.getTeacherId());
		System.out.println(t.getUsersId());
		Users u = daoU.findById(usersId);
		u.setIsStudent((short)1);
		daoU.save(u);
		daoT.delete(t);
		return "success";
	}
	
	public String setDescribe(int organizationId, String describe) {
		
		Organization organization = new Organization();
		organization = daoO.findById(organizationId);
		if(organization == null)
			return "error";
		else {
			organization.setDescription(describe);
			return "success";
		}
	}
	
	public List<Classes> getAllClassesOfOrganization (int organizationId) {
		
		List<Classes> listClasses = new ArrayList<Classes>();
		OrganizationClassesTeacher oct = new OrganizationClassesTeacher();
		oct.setOrganizationId(organizationId);
		List<OrganizationClassesTeacher> listOCT = daoOCT.findByExample(oct);
		for(int i = 0; i < listOCT.size(); i++) {
			Classes c = new Classes();
			oct = listOCT.get(i);
			c.setClassId(oct.getClassId());
			c.setClassName(oct.getClassName());
			c.setImageId(oct.getImageId());
			c.setClassType(oct.getClassName());
			c.setDescription(oct.getDescription());
			listClasses.add(c);
		}
		return listClasses;
	}
	
	public List<Users> getAllTeacherOfOrganization(int organizationId) {
		
		List<Users> listTeacher = new ArrayList<Users>();
		OrganizationClassesTeacher oct = new OrganizationClassesTeacher();
		oct.setOrganizationId(organizationId);
		List<OrganizationClassesTeacher> listOCT = daoOCT.findByExample(oct);
		for(int i = 0; i < listOCT.size(); i++) {
			Users u = new Users();
			oct = listOCT.get(i);
			listTeacher.add(daoU.findById(oct.getUsersId()));
		}
		return listTeacher;
	}
	
	@SuppressWarnings("unchecked")
	public List<Organization> findByKeyword(String keyword, String city) {
		
		return daoO.findByKeyword(keyword, city);
	}
	
	public List<Organization> findByCity(String city) {
		
		return daoO.findByCity(city);
	}
	
	public boolean isOrganization(int usersId) {
		
		return !daoOU.findByProperty("usersId", usersId).isEmpty();
	}
	
	public String addOrganization(Integer usersId, String organizationName, 
			String description, String city, 
			String address, String tel) {
		
		if(isOrganization(usersId) && new TeacherService().isTeacher(usersId))
			return "error";
		try {
			Organization o = new Organization();
			o.setUsersId(usersId);
			o.setOrganizationName(organizationName);
			o.setDescription(description);
			o.setCity(city);
			o.setAddress(address);
			o.setTel(tel);
			Users u = daoU.findById(usersId);
			u.setIsStudent((short)3);
			daoU.save(u);
			daoO.save(o);
			return "success";
		} catch(Exception e) {
			return "error";
		}
	}
	
	public String modifyOrganization(int organizationId, String organizationName, 
			String description, String city, 
			String address, String tel) {
		
		try {
			Organization o = daoO.findById(organizationId);
			o.setOrganizationName(organizationName);
			o.setDescription(description);
			o.setCity(city);
			o.setAddress(address);
			o.setTel(tel);
			daoO.save(o);
			return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String setImage(int organizationId, int imageId) {
		try {
			Organization o = daoO.findById(organizationId);
			o.setImage(imageId);
			daoO.save(o);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String setDescriptionImage(int organizationId, int []describeImageId) {
		
		try {
			Organization o = daoO.findById(organizationId);
			o.setDescribeImageId1(describeImageId[0]);
			o.setDescribeImageId2(describeImageId[1]);
			o.setDescribeImageId3(describeImageId[2]);
			daoO.save(o);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delOrganization(int organizationId) {
		
		try {
			Organization o = daoO.findById(organizationId);
			daoU.findById(o.getUsersId()).setIsStudent((short)1);
			daoO.delete(o);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
