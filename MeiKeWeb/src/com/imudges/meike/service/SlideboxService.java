package com.imudges.meike.service;

import java.util.List;

import com.imudges.meike.DAO.SlideboxDAO;
import com.imudges.meike.bean.Slidebox;

public class SlideboxService {
	public Slidebox getSlideboxService(){
		SlideboxDAO slideboxDAO=new SlideboxDAO();
		List list=slideboxDAO.findAll();
		return (Slidebox)list.get(0);
	}
}
