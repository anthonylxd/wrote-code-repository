package com.service;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.tool.DBAccess;
import com.dao.commentDao;
import com.entity.comment;

public class commentService {
	commentDao commentDao;
	SqlSession sqlSession;
	public commentService() throws IOException{
		DBAccess dbaccess = new DBAccess();
		sqlSession = dbaccess.getSqlSession();
		commentDao = sqlSession.getMapper(commentDao.class);
	}
	//发表评论
	public boolean insert(comment comment) {
		int result = commentDao.commentInsert(comment);
		sqlSession.commit();
		if(result == 1){
		return true;
		}else{
			return false;
		}
	}
	//查询评论
	public List<comment> selectById(int commentId) {
		List<comment> comments = commentDao.commentById(commentId);
		return comments;
	}
	//删除单条评论
	public boolean oneDelete(int commentId) {
		int result = commentDao.commentDelete(commentId);
		sqlSession.commit();
		if(result == 1){
		return true;
		}else{
			return false;
		}
	}
	//删除一条微博删除其所有评论
	public boolean manyDelete(int commentWeiboId) {
		int result = commentDao.commentDeleteByWeibo(commentWeiboId);
		sqlSession.commit();
		return false;
	}
}
