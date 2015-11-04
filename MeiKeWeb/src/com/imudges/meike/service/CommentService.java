package com.imudges.meike.service;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;







import com.imudges.meike.DAO.CommentDAO;
import com.imudges.meike.DAO.CommentUsersDAO;
import com.imudges.meike.bean.Comment;
import com.imudges.meike.bean.CommentUsers;
import com.imudges.meike.bean.CommentUsersId;

public class CommentService {
	private CommentDAO comdao = new CommentDAO();
	private Comment comment = new Comment();
	private CommentUsersDAO comusedao = new CommentUsersDAO();
	private CommentUsers commentusers = new CommentUsers();
	public boolean saveComment(Integer usersId, String commentstring, Integer commentRank,
			Integer type, Integer id, Timestamp commentDate){
		comment = new Comment(usersId,commentstring,commentRank,type,id,commentDate);
		comdao.save(comment);
		return true;
	}
	public List<CommentUsers> getComment(Integer type ,Integer id){
		commentusers.setType(type);
		commentusers.setTypeId(id);
		List<CommentUsers> commentuselist =comusedao.findByExample(commentusers);
		Collections.reverse(commentuselist);	
		return commentuselist;
	}
	public List<CommentUsers> getUsersComment(int UsersId)
	{
		CommentUsers comusers = new CommentUsers();
		comusers.setUsersId(UsersId);
		return comusedao.findByExample(comusers);
	}
	public boolean deleteComment(Integer usersId,Integer type, Integer id, String commentstring){
		comment.setComment(commentstring);
		comment.setType(id);
		comment.setType(type);
		comment.setUsersId(usersId);
		comdao.delete((Comment)comdao.findByExample(comment).get(0));
		return true;
	}
	
	public String getcommentRank(Integer type, Integer id){
		int sum,Number;
		sum = 0;
		Number = 0;
		DecimalFormat    df   = new DecimalFormat("######0.0");   
		comment.setTypeId(id);
		comment.setType(type);
		List<Comment> commentlist = comdao.findByExample(comment);
		for (Comment C:commentlist)
		{
			Number+=C.getCommentRank();
			sum++;
		}
		if(sum==0){
			return "0";
		}
		return df.format(Number/sum);
	}
	public int getcommentRank(Integer type, Integer id,boolean isStar){
		int sum,Number;
		sum = 0;
		Number = 0;
		comment.setTypeId(id);
		comment.setType(type);
		List<Comment> commentlist = comdao.findByExample(comment);
		for (Comment C:commentlist)
		{
			Number+=C.getCommentRank();
			sum++;
		}
		if(sum==0){
			return 0;
		}
		Number=Number*2;
		return Number/sum;
	}
}
