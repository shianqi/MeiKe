package com.imudges.meike.utils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.imudges.meike.DAO.LogDAO;
import com.imudges.meike.bean.Log;

public class Loger {

	private static LogDAO daoLog = new LogDAO();
	private static Log log;
	
	private static String getOperateName(Object operator) {
		
		String str = operator.getClass().getName();
		str = str.substring(str.lastIndexOf(".") + 1);
		return str;
	}
	
	public static void addLog(int usersId, Object operator) {
		
		log = new Log();
		String logstr = "do: " + getOperateName(operator);
		log.setLogMessage(logstr);
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setUsersId(usersId);
		daoLog.save(log);
	}
	
	public static void addLog(int usersId, String logstr) {
		
		log = new Log();
		log.setLogMessage(logstr);
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setUsersId(usersId);
		daoLog.save(log);
	}
	
	public static void addLog(int usersId, String operator, String obj) {
		
		log = new Log();
		String logstr = "do: " + operator + " on: " + obj;
		log.setLogMessage(logstr);
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setUsersId(usersId);
		daoLog.save(log);
	}
	
	public static void addLog(int usersId, Object operator, String obj) {
		
		log = new Log();
		String logstr = "do: " + getOperateName(operator) + " on: " + obj;
		log.setLogMessage(logstr);
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setUsersId(usersId);
		daoLog.save(log);
	}
	
	public static void addLog(int usersId, Object operator, Object obj, int objId) {
		
		log = new Log();
		String logstr = "do: " + getOperateName(operator) + "on: " + getOperateName(obj) + ":" + objId;
	}
	
	public static List<Log> getAllLog() {
		
		return daoLog.findAll();
	}
	
	public static List<Log> getLogByUsersId(int usersId) {
		
		return daoLog.findByUsersId(usersId);
	}
	
	public static List<Log> getLogByOperate(Object operator) {
		
		return daoLog.findByKeyword(getOperateName(operator));
	}
	
	public static List<Log> getLogByOperate(String operator) {
		
		return daoLog.findByKeyword(operator);
	}
}
