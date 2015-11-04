package com.imudges.meike.service;

import com.imudges.meike.DAO.ClassesimageDAO;
import com.imudges.meike.DAO.ImageDAO;
import com.imudges.meike.DAO.OrganizationImageDAO;
import com.imudges.meike.DAO.UserimageDAO;
import com.imudges.meike.bean.Classes;
import com.imudges.meike.bean.Classesimage;
import com.imudges.meike.bean.ClassesimageId;
import com.imudges.meike.bean.Image;
import com.imudges.meike.bean.Organization;
import com.imudges.meike.bean.OrganizationImage;
import com.imudges.meike.bean.Userimage;
import com.imudges.meike.bean.UserimageId;
import com.imudges.meike.bean.Users;

public class ImageService {
	private Image image;
	private ImageDAO imagedao = new ImageDAO();
	private UserimageDAO Uidao = new UserimageDAO();
	private ClassesimageDAO daoCI = new ClassesimageDAO();
	private OrganizationImageDAO daoOI = new OrganizationImageDAO();
	public Integer saveImage(String url)
	{
		Image Newimage = new Image(url);
		
			imagedao.save(Newimage);
			return Newimage.getImageId();
		
	}
	public String getImage(Users user)
	{
		int imageId = user.getImageId();
		return imagedao.findById(imageId).getUrl();
	}
	public String getImage(Classes classes) {
		
		int imageId = classes.getImageId();
		return (imagedao.findById(imageId).getUrl());
	}
	public String getImage(Organization organization,int Number) {
		int imageId = 1;
		if(Number==0)
		{
			imageId = organization.getImage();
		} else if(Number==1)
		{
			imageId = organization.getDescribeImageId1();
		} else if(Number==2)
		{
			imageId = organization.getDescribeImageId2();
		}
		else if(Number==3)
		{
			imageId = organization.getDescribeImageId3();
		}
		return imagedao.findById(imageId).getUrl();
	}
	public boolean modifyImage(Organization organzation,int Number,String newurl) {
		if(Number==0)
		{
			int organzationId = organzation.getImage();
			image=imagedao.findById(organzationId);
			image.setUrl(newurl);
			imagedao.save(image);
			return true;
		}
		if(Number==1)
		{
			int organzationId = organzation.getDescribeImageId1();
			image=imagedao.findById(organzationId);
			image.setUrl(newurl);
			imagedao.save(image);
			return true;
		}
		if(Number==2)
		{
			int organzationId = organzation.getDescribeImageId2();
			image=imagedao.findById(organzationId);
			image.setUrl(newurl);
			imagedao.save(image);
			return true;
		}
		if(Number==3)
		{
			int organzationId = organzation.getDescribeImageId3();
			image=imagedao.findById(organzationId);
			image.setUrl(newurl);
			imagedao.save(image);
			return true;
		}
		return false;
	}
	public boolean modifyImage(Users user,String NewUrl)
	{
		Image Newimage = new Image();
		Newimage = (Image) imagedao.findByUrl(getImage(user));
		Newimage.setUrl(NewUrl);
		imagedao.save(Newimage);
		return true;
	}
	public boolean modifyImage(Classes classes,String NewUrl)
	{
		Image Newimage = new Image();
		Newimage = (Image) imagedao.findByUrl(getImage(classes));
		Newimage.setUrl(NewUrl);
		imagedao.save(Newimage);
		return true;
	}
	public boolean deleteImage(Users user)
	{
		int UserId = user.getUsersId();
		Userimage Ui = new Userimage();
		UserimageId Uid = new UserimageId(UserId);
		Ui = Uidao.findById(Uid);
		imagedao.delete(imagedao.findById(Ui.getId().getImageId()));
		return true;
	}
	public boolean deleteImage(Classes classes)
	{
		int classid = classes.getClassId();
	    imagedao.delete(imagedao.findById(daoCI.findById(new ClassesimageId(classid)).getId().getImageId()));
		return true;
	}
	public boolean deleteImage(Organization organzation,int Number) {
		if(Number==0)
		{
			int organzationId = organzation.getImage();
			image=imagedao.findById(organzationId);
			imagedao.delete(image);
			return true;
		}
		if(Number==1)
		{
			int organzationId = organzation.getDescribeImageId1();
			image=imagedao.findById(organzationId);
			imagedao.delete(image);
			return true;
		}
		if(Number==2)
		{
			int organzationId = organzation.getDescribeImageId2();
			image=imagedao.findById(organzationId);
			imagedao.delete(image);
			return true;
		}
		if(Number==3)
		{
			int organzationId = organzation.getDescribeImageId3();
			image=imagedao.findById(organzationId);
			imagedao.delete(image);
			return true;
		}
		return false;
	}
	public String getImage(Organization organization) {
		int Id = organization.getImage();
		Image oImage=imagedao.findById(Id);
		return oImage.getUrl();
	}
}
