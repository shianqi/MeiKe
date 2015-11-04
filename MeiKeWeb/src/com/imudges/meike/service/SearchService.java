package com.imudges.meike.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.imudges.meike.DAO.MostSearchItemDAO;
import com.imudges.meike.DAO.SearchDAO;
import com.imudges.meike.bean.MostSearchItem;
import com.imudges.meike.bean.MostSearchItemId;
import com.imudges.meike.bean.Search;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.core.ReturnInstruction.Return;

public class SearchService{
	
	public String getHotSearchString(){
		MostSearchItemDAO mostSearchItemDAO=new MostSearchItemDAO();
		List list=mostSearchItemDAO.findAll();
		MostSearchItem mostSearchItem=(MostSearchItem)list.get(0);
		return mostSearchItem.getSearchStr();
	}
	
	public void save(Search search){
		if (search.getSearchStr()==null) {
			return;
		}
		SearchDAO searchDAO=new SearchDAO();
		search.setSearchDate(new Timestamp(System.currentTimeMillis()));
		searchDAO.save(search);
	}
	
	public void save(String searchStr){
		if (searchStr==null) {
			return;
		}
		Search search=new Search();
		search.setSearchDate(new Timestamp(System.currentTimeMillis()));
		search.setSearchStr(searchStr);
		SearchDAO searchDAO=new SearchDAO();
		searchDAO.save(search);
	}
	
	public List getSearchresult(String searchStr){
		Search search=new Search();
		search.setSearchStr(searchStr);
		SearchDAO searchDAO=new SearchDAO();
		List list=searchDAO.findByExample(search);
		return list;
	}
	
}
