package com.imudges.meike.myUnitTest;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.imudges.meike.DAO.ClassesDAO;
import com.imudges.meike.DAO.ClassesimageDAO;
import com.imudges.meike.DAO.OrganizationUsersDAO;
import com.imudges.meike.DAO.StudentUsersChooseclassDAO;
import com.imudges.meike.DAO.UsersDAO;
import com.imudges.meike.action.ChooseClassesAction;
import com.imudges.meike.action.LoginAction;
import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.StudentUsersChooseclass;
import com.imudges.meike.bean.StudentUsersChooseclassId;
import com.imudges.meike.bean.Users;
import com.imudges.meike.service.ClassesService;
import com.imudges.meike.service.ImageService;
import com.imudges.meike.service.OrganizationService;
import com.imudges.meike.utils.*;
public class MyTest {

	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void testList() {
		
		ClassesService cs = new ClassesService();
		//System.out.println(cs.cancelClasses(28, 14));
	}
	
	@Test
	public void testLog() {
		
		//Loger.addLog(1, "fuck", "class1");
		OrganizationService os = new OrganizationService();
		//System.out.println(os.addOrganization(1, "dmd", "dew", "∫Ù∫Õ∫∆Ãÿ –", "dieiei", "47788777"));
		System.out.println(os.setTeacherToStudent(1, 12));
	}
}
